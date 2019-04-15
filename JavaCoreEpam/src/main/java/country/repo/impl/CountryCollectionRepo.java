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

import static storage.Storage.*;
import static storage.Storage.countryList;

public class CountryCollectionRepo implements CountryRepo {

    @Override
    public Country insert(Country country) {

        country.setId(SequenceIDGenerator.getNextID());
        countryList.add(country);

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
        for (Country country : countryList) {
            if ((country != null) && (country.getId().equals(id))) {
                return Optional.of(country);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Country> findAll() {
        return new ArrayList<>(Arrays.asList(countryArray));
    }

    @Override
    public void deleteById(Long id) {
        Optional<Country> countryToRemove = findById(id);
        countryToRemove.ifPresent(country -> countryList.remove(country));
    }

    @Override
    public void printAll() {
        for (Country country : countryArray) {
            System.out.println(country);
        }
    }


    @Override
    public List<? extends Country> search(CountrySearchCondition searchCondition) {
        CountryDiscriminator countryDiscriminator = searchCondition.getCountryDiscriminator();

        List<? extends Country> resultList = countryList;

        if (countryDiscriminator.equals(CountryDiscriminator.HOT)) {
            resultList = searchHotCountry((HotCountrySearchCondition) searchCondition);
        } else if (countryDiscriminator.equals(CountryDiscriminator.COLD)) {
            resultList = searchColdCountry((ColdCountrySearchCondition) searchCondition);
        }

        return resultList;
    }


    private List<? extends Country> searchHotCountry(HotCountrySearchCondition searchCondition) {
        List<Country> foundCountries = new ArrayList<>();

        for (Country country : countryList) {
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
                    foundCountries.add(country);
                }
            }
        }

        return foundCountries;
    }

    private List<? extends Country> searchColdCountry(ColdCountrySearchCondition searchCondition) {
        List<Country> foundCountries = new ArrayList<>();

        for (Country country : countryList) {
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
                    foundCountries.add(country);
                }
            }
        }

        return foundCountries;
    }
}
