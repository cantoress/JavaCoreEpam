package order.repo.impl;

import order.domain.Order;
import order.repo.OrderRepo;
import order.search.OrderSearchCondition;
import storage.SequenceIDGenerator;

import java.util.*;

import static storage.Storage.orderArray;

public class OrderArrayRepo implements OrderRepo {
    private int orderIndex = 0;

    @Override
    public void deleteByUserId(long userId) {
        List<Order> foundOrders = findByUserId(userId);
        for (Order order : foundOrders) {
            deleteById(order.getId());
        }
    }

    @Override
    public List<Order> findByUserId(long userId) {
        Order[] foundOrders = new Order[orderArray.length];
        int resultIndex = 0;
        for (Order order : orderArray) {
            if ((order != null) && (order.getUser().getId().equals(userId))) {
                foundOrders[resultIndex] = order;
                resultIndex++;
            }
        }
        if (resultIndex != 0) {
            Order[] resultOrders = new Order[resultIndex];
            System.arraycopy(foundOrders, 0, resultOrders, 0, resultIndex);
            return new ArrayList<>(Arrays.asList(resultOrders));
        }

        return Collections.emptyList();
    }

    @Override
    public int countByUser(long userId) {
        int result = 0;
        for (Order order : orderArray) {
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
        for (Order order : orderArray) {
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
        for (Order order : orderArray) {
            if (order.getCountry().getId().equals(countryId)) {
                result++;
            }
            ;
        }
        return result;
    }

    @Override
    public Order insert(Order order) {
        if (orderIndex == orderArray.length) {
            Order[] newOrderArray = new Order[orderArray.length * 2];
            System.arraycopy(orderArray, 0, newOrderArray, 0, orderArray.length);
            orderArray = newOrderArray;
        }
        orderIndex++;
        order.setId(SequenceIDGenerator.getNextID());
        orderArray[orderIndex] = order;

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
        int index = findOrderIndexFromID(id);
        if (index != -1) {
            return Optional.of(orderArray[index]);
        }
        return Optional.empty();
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(Arrays.asList(orderArray));
    }

    @Override
    public void deleteById(Long id) {
        int index = findOrderIndexFromID(id);
        if (index != -1) {
            System.arraycopy(orderArray, index + 1, orderArray, index, orderArray.length - index - 1);
        }
    }

    @Override
    public void printAll() {
        for (Order order : orderArray) {
            System.out.println(order);
        }
    }

    @Override
    public List<Order> search(OrderSearchCondition searchCondition) {
        Order[] foundOrders = new Order[orderArray.length];
        int resultIndex = 0;

        for (Order order : orderArray) {
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
                foundOrders[resultIndex] = order;
                resultIndex++;
            }
        }
        if (resultIndex != 0) {
            Order[] resultOrders = new Order[resultIndex];
            System.arraycopy(foundOrders, 0, resultOrders, 0, resultIndex);
            return new ArrayList<>(Arrays.asList(resultOrders));
        }

        return Collections.emptyList();
    }


    private int findOrderIndexFromID(long id) {
        for (int i = 0; i < orderArray.length; i++) {
            Order order = orderArray[i];
            if ((order != null) && (order.getId().equals(id))) {
                return i;
            }
        }
        return -1;
    }
}



