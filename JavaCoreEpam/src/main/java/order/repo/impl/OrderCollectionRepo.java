package order.repo.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import order.domain.Order;
import order.repo.OrderRepo;
import order.search.OrderSearchCondition;
import storage.SequenceIDGenerator;

import java.util.*;

import static storage.Storage.orderList;

public class OrderCollectionRepo implements OrderRepo {


    @Override
    public void deleteByUserId(long userId) {
        List<Order> foundOrders = findByUserId(userId);
        for (Order order : foundOrders) {
            deleteById(order.getId());
        }
    }

    @Override
    public List<Order> findByUserId(long userId) {
        List<Order> foundOrders = new ArrayList<>();

        for (Order order : orderList) {
            if ((order != null) && (order.getUser().getId().equals(userId))) {
                foundOrders.add(order);
            }
        }

        return foundOrders;
    }

    @Override
    public Order insert(Order order) {
        order.setId(SequenceIDGenerator.getNextID());
        orderList.add(order);
        return order;
    }

    @Override
    public void insert(Collection<Order> items) {
        for (Order order : items) {
            insert(order);
        }
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public Optional<Order> findById(Long id) {
        for (Order order : orderList) {
            if ((order != null) && (order.getId().equals(id))) {
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Order> findAll() {
        return orderList;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Order> orderToRemove = findById(id);
        orderToRemove.ifPresent(order -> orderList.remove(order));
    }

    @Override
    public void printAll() {
        for (Order order : orderList) {
            System.out.println(order);
        }

    }

    @Override
    public List<Order> search(OrderSearchCondition searchCondition) {
        List<Order> foundOrders = new ArrayList<>();

        for (Order order : orderList) {
            boolean found = true;

            if (searchCondition.searchByUserId()) {
                found = searchCondition.getUserId().equals(order.getUser().getId());
            }

            if (found && searchCondition.searchByCountryId()) {
                found = searchCondition.getCountryId().equals(order.getCountry().getId());
            }
            if (found && searchCondition.searchByCityId()) {
                found = searchCondition.getCityId().equals(order.getCity().getId());
            }

            if (found) {
                foundOrders.add(order);
            }
        }

        return foundOrders;
    }

    @Override
    public int countByUser(long userId) {
        int result = 0;
        for (Order order : orderList) {
            if (order.getUser().getId().equals(userId)) {
                result++;
            }
            ;
        }
        return result;
    }

    @Override
    public int countByCity(long cityId) {
        int result = 0;
        for (Order order : orderList) {
            if (order.getCity().getId().equals(cityId)) {
                result++;
            }
            ;
        }
        return result;
    }

    @Override
    public int countByCountry(long countryId) {
        int result = 0;
        for (Order order : orderList) {
            if (order.getCountry().getId().equals(countryId)) {
                result++;
            }
            ;
        }
        return result;
    }
}
