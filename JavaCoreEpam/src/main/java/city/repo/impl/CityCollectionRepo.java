package city.repo.impl;

import city.domain.City;
import city.repo.CityRepo;
import city.search.CitySearchCondition;
import storage.SequenceIDGenerator;

import java.util.*;


import static storage.Storage.cityList;

public class CityCollectionRepo implements CityRepo {

    @Override
    public City insert(City city) {
        city.setId(SequenceIDGenerator.getNextID());
        cityList.add(city);
        return city;
    }

    @Override
    public void insert(Collection<City> items) {
        for(City city: items){
            insert(city);
        }
    }

    @Override
    public void update(City item) {
        // No need to update anything
    }

    @Override
    public Optional<City> findById(Long id) {
        for (City city: cityList) {
            if ((city != null) && (city.getId().equals(id))) {
                return Optional.of(city);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<City> findAll() {
        return cityList;
    }

    @Override
    public void deleteById(Long id) {
        Optional<City> cityToRemove = findById(id);
        cityToRemove.ifPresent(city -> cityList.remove(city));
    }

    @Override
    public void printAll() {
        for(City city: cityList){
            System.out.println(city);
        }
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        List<City> foundCities = new ArrayList<>();

        for (City city : cityList) {
            boolean found = true;

            if (searchCondition.searchByName()) {
                found = searchCondition.getName().equals(city.getName());
            }

            if (found && searchCondition.searchByPopulation()) {
                found = searchCondition.getPopulation() == city.getPopulation();
            }

            if (found) {
                foundCities.add(city);
            }
        }

        return foundCities;
    }
}
