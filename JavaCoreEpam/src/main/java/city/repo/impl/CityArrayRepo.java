package city.repo.impl;

import city.domain.City;
import city.repo.CityRepo;
import city.search.CitySearchCondition;
import storage.SequenceIDGenerator;

import java.util.*;

import static storage.Storage.cityArray;

public class CityArrayRepo implements CityRepo {

    private int cityIndex = 0;

    @Override
    public City insert(City city) {
        if (cityIndex == cityArray.length) {
            City[] newCityArray = new City[cityArray.length * 2];
            System.arraycopy(cityArray, 0, newCityArray, 0, cityArray.length);
            cityArray = newCityArray;
        }
        cityIndex++;
        city.setId(SequenceIDGenerator.getNextID());
        cityArray[cityIndex] = city;

        return city;
    }

    @Override
    public void insert(Collection<City> items) {
        for (City city : items) {
            insert(city);
        }

    }

    @Override
    public void update(City city) {
        //Don't need to update anything
    }

    @Override
    public Optional<City> findById(Long id) {
        int index = findCityIndexFromID(id);
        if (index != -1) {
            return Optional.of(cityArray[index]);
        }
        return Optional.empty();
    }

    @Override
    public List<City> findAll() {
        return new ArrayList<>(Arrays.asList(cityArray));
    }

    @Override
    public void deleteById(Long id) {
        int index = findCityIndexFromID(id);
        if (index != -1) {
            System.arraycopy(cityArray, index + 1, cityArray, index, cityArray.length - index - 1);
        }
    }

    @Override
    public void printAll() {
        for (City city : cityArray) {
            System.out.println(city);
        }
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        City[] foundCities = new City[cityArray.length];
        int resultIndex = 0;

        for (City city : cityArray) {
            boolean found = true;

            if (searchCondition.searchByName()) {
                found = searchCondition.getName().equals(city.getName());
            }

            if (found && searchCondition.searchByPopulation()) {
                found = searchCondition.getPopulation() == city.getPopulation();
            }

            if (found) {
                foundCities[resultIndex] = city;
                resultIndex++;
            }
        }
        if (resultIndex != 0) {
            City[] resultCities = new City[resultIndex];
            System.arraycopy(foundCities, 0, resultCities, 0, resultIndex);
            return new ArrayList<>(Arrays.asList(resultCities));
        }

        return Collections.emptyList();
    }

    private int findCityIndexFromID(long id) {
        for (int i = 0; i < cityArray.length; i++) {
            City city = cityArray[i];
            if ((city != null) && (city.getId().equals(id))) {
                return i;
            }
        }
        return -1;
    }
}
