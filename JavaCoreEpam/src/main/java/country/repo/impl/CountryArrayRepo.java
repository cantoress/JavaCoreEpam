package country.repo.impl;

import country.domain.ColdCountry;
import country.domain.Country;
import country.domain.CountryDiscriminator;
import country.domain.HotCountry;
import country.repo.CountryRepo;
import country.search.ColdCountrySearchCondition;
import country.search.CountrySearchCondition;
import country.search.HotCountrySearchCondition;
import storage.SequenceIDGenerator;

import java.util.*;

import static storage.Storage.countryArray;
import static storage.Storage.countryList;

public class CountryArrayRepo implements CountryRepo {

    private int countryIndex = 0;

    @Override
    public Country insert(Country country) {
        if (countryIndex == countryArray.length) {
            Country[] newCountryArray = new Country[countryArray.length * 2];
            System.arraycopy(countryArray, 0, newCountryArray, 0, countryArray.length);
            countryArray = newCountryArray;
        }
        countryIndex++;
        country.setId(SequenceIDGenerator.getNextID());
        countryArray[countryIndex] = country;

        return country;
    }


    @Override
    public void insert(Collection<Country> items) {
        for (Country country : items) {
            insert(country);
        }
    }

    @Override
    public void update(Country item) {
        //Don't need to update anything for now
    }

    @Override
    public Optional<Country> findById(Long id) {
        int index = findCountryIndexFromID(id);
        if (index != -1) {
            return Optional.of(countryArray[index]);
        }
        return Optional.empty();
    }

    @Override
    public List<Country> findAll() {
        return new ArrayList<>(Arrays.asList(countryArray));
    }

    @Override
    public void deleteById(Long id) {
        int index = findCountryIndexFromID(id);
        if (index != -1) {
            System.arraycopy(countryArray, index + 1, countryArray, index, countryArray.length - index - 1);
        }
    }

    @Override
    public void printAll() {
        for (Country country : countryArray) {
            System.out.println(country);
        }
    }


    private int findCountryIndexFromID(long id) {
        for (int i = 0; i < countryArray.length; i++) {
            Country country = countryArray[i];
            if ((country != null) && (country.getId().equals(id))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<? extends Country> search(CountrySearchCondition searchCondition) {
        CountryDiscriminator countryDiscriminator = searchCondition.getCountryDiscriminator();

        List<? extends Country> resultList = new ArrayList<>(Arrays.asList(countryArray));

        if (countryDiscriminator.equals(CountryDiscriminator.HOT)) {
            resultList = searchHotCountry((HotCountrySearchCondition) searchCondition);
        } else if (countryDiscriminator.equals(CountryDiscriminator.COLD)) {
            resultList = searchColdCountry((ColdCountrySearchCondition) searchCondition);
        }

        return resultList;
    }


    private List<? extends Country> searchHotCountry(HotCountrySearchCondition searchCondition) {
        Country[] foundCountries = new Country[countryArray.length];
        int resultIndex = 0;

        for (Country country : countryArray) {
            if (country.getCountryDiscriminator().equals(CountryDiscriminator.HOT)) {
                HotCountry hotCountry = (HotCountry) country;
                boolean found = true;

                if (searchCondition.searchByName()) {
                    found = searchCondition.getName().equals(hotCountry.getName());
                }

                if (found && searchCondition.searchByLanguage()) {
                    found = searchCondition.getLanguage().equals(hotCountry.getLanguage());
                }

                if (found && searchCondition.searchByHottestMonth()) {
                    found = searchCondition.getHottestMonth() == hotCountry.getHottestMonth();
                }

                if (found && searchCondition.searchByAverageTemperature()) {
                    found = searchCondition.getAverageTemperature() == hotCountry.getAverageTemperature();
                }

                if (found) {
                    foundCountries[resultIndex] = hotCountry;
                    resultIndex++;
                }
            }
        }
        if (resultIndex != 0) {
            Country[] resultCountries = new Country[resultIndex];
            System.arraycopy(foundCountries, 0, resultCountries, 0, resultIndex);
            return new ArrayList<>(Arrays.asList(resultCountries));
        }

        return Collections.emptyList();
    }

    private List<? extends Country> searchColdCountry(ColdCountrySearchCondition searchCondition) {
        Country[] foundCountries = new Country[countryArray.length];
        int resultIndex = 0;

        for (Country country : countryArray) {
            if (country.getCountryDiscriminator().equals(CountryDiscriminator.COLD)) {
                ColdCountry coldCountry = (ColdCountry) country;
                boolean found = true;

                if (searchCondition.searchByName()) {
                    found = searchCondition.getName().equals(coldCountry.getName());
                }

                if (found && searchCondition.searchByLanguage()) {
                    found = searchCondition.getLanguage().equals(coldCountry.getLanguage());
                }

                if (found && searchCondition.searchByHasPolarNights()) {
                    found = searchCondition.isHasPolarNights() == coldCountry.isHasPolarNights();
                }

                if (found && searchCondition.searchByTelephoneCode()) {
                    found = searchCondition.getTelephoneCode() == coldCountry.getTelephoneCode();
                }

                if (found) {
                    foundCountries[resultIndex] = coldCountry;
                    resultIndex++;
                }
            }
        }
        if (resultIndex != 0) {
            Country[] resultCountries = new Country[resultIndex];
            System.arraycopy(foundCountries, 0, resultCountries, 0, resultIndex);
            return new ArrayList<>(Arrays.asList(resultCountries));
        }

        return Collections.emptyList();
    }

}
