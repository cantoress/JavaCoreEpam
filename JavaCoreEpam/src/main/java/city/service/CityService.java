package city.service;

import city.domain.City;
import city.search.CitySearchCondition;
import common.solutions.service.BaseService;

import java.util.List;

public interface CityService extends BaseService<Long, City> {
    List<City> search(CitySearchCondition searchCondition);
}
