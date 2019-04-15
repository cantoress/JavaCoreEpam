package city.repo;

import city.domain.City;
import city.search.CitySearchCondition;
import common.solutions.repo.BaseRepo;

import java.util.List;

public interface CityRepo extends BaseRepo<Long, City> {
    List<City> search(CitySearchCondition searchCondition);
}
