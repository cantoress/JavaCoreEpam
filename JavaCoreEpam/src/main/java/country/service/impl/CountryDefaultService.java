package country.service.impl;

import common.business.exception.CustomUncheckedException;
import country.domain.Country;
import country.exception.DeleteCountryException;
import country.repo.CountryRepo;
import country.search.CountrySearchCondition;
import country.service.CountryService;
import order.repo.OrderRepo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static country.exception.CountryExceptionInformation.DELETE_USED_COUNTRY;

public class CountryDefaultService implements CountryService {


    private CountryRepo countryRepo;
    private OrderRepo orderRepo;

    public CountryDefaultService(CountryRepo countryRepo, OrderRepo orderRepo) {
        this.countryRepo = countryRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public Country insert(Country country) {
        if (country != null) {
            countryRepo.insert(country);
        }
        return country;
    }

    @Override
    public void insert(Collection<Country> items) {
        if (items != null) {
            countryRepo.insert(items);
        }
    }

    @Override
    public void update(Country country) {
        if (country != null) {
            countryRepo.update(country);
        }
    }

    @Override
    public Optional<Country> findById(Long id) {
        if (id != null) {
            return countryRepo.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Country> findAll() {
        return countryRepo.findAll();
    }

    @Override
    public void deleteById(Long id) throws CustomUncheckedException {
        if (id != null) {
            int ordersWithCountry = orderRepo.countByCountry(id);
            if (ordersWithCountry != 0) {
                throw new DeleteCountryException(DELETE_USED_COUNTRY);
            } else {
                countryRepo.deleteById(id);
            }
        }
    }

    @Override
    public void delete(Country country) {
        if (country != null) {
            deleteById(country.getId());
        }

    }

    @Override
    public void printAll() {
        countryRepo.printAll();
    }

    @Override
    public List<? extends Country> search(CountrySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            Optional<Country> foundCountry = findById(searchCondition.getId());
            if (foundCountry.isPresent()) {
                return Collections.singletonList(foundCountry.get());
            } else {
                return Collections.emptyList();
            }

        } else {
            return countryRepo.search(searchCondition);
        }
    }
}
