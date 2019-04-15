package country.service;

import common.solutions.service.BaseService;
import country.domain.Country;
import country.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService<Long, Country> {
    List<? extends Country> search(CountrySearchCondition searchCondition);
}
