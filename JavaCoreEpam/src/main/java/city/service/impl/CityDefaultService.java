package city.service.impl;

import city.domain.City;
import city.exception.DeleteCityException;
import city.repo.CityRepo;
import city.search.CitySearchCondition;
import city.service.CityService;
import common.business.exception.CustomUncheckedException;
import order.repo.OrderRepo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static city.exception.CityExceptionInformation.DELETE_USED_CITY;

public class CityDefaultService implements CityService {

    private CityRepo cityRepo;
    private OrderRepo orderRepo;

    public CityDefaultService(CityRepo cityRepo, OrderRepo orderRepo) {
        this.cityRepo = cityRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public City insert(City city) {
        if (city != null) {
            cityRepo.insert(city);
        }
        return city;
    }

    @Override
    public void insert(Collection<City> items) {
        if (items != null) {
            cityRepo.insert(items);
        }
    }

    @Override
    public void update(City city) {
        if (city != null) {
            cityRepo.update(city);
        }
    }

    @Override
    public Optional<City> findById(Long id) {
        if (id != null) {
            return cityRepo.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<City> findAll() {
        return cityRepo.findAll();
    }

    @Override
    public void deleteById(Long id) throws CustomUncheckedException {
        if (id != null) {
            int ordersWithCity = orderRepo.countByCity(id);
            if (ordersWithCity != 0) {
                throw new DeleteCityException(DELETE_USED_CITY);
            } else {
                cityRepo.deleteById(id);
            }
        }

    }

    @Override
    public void delete(City city) {
        if (city != null) {
            deleteById(city.getId());
        }
    }

    @Override
    public void printAll() {
        cityRepo.printAll();
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            Optional<City> foundCity = findById(searchCondition.getId());
            if (foundCity.isPresent()) {
                return Collections.singletonList(foundCity.get());
            } else {
                return Collections.emptyList();
            }

        } else {
            return cityRepo.search(searchCondition);
        }
    }

}
