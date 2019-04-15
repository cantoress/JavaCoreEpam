package order.repo;

import common.solutions.repo.BaseRepo;
import order.domain.Order;
import order.search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo<Long, Order> {

    List<Order> search(OrderSearchCondition searchCondition);

    void deleteByUserId(long userId);

    List<Order> findByUserId(long userId);

    int countByUser(long userId);

    int countByCity(long cityId);

    int countByCountry(long countryId);

}
