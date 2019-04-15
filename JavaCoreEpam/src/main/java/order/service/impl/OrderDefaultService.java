package order.service.impl;

import common.business.exception.CustomUncheckedException;
import order.domain.Order;
import order.repo.OrderRepo;
import order.search.OrderSearchCondition;
import order.service.OrderService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OrderDefaultService implements OrderService {

    private OrderRepo orderRepo;

    public OrderDefaultService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order insert(Order order) {
        if (order != null) {
            orderRepo.insert(order);
        }
        return order;
    }

    @Override
    public void insert(Collection<Order> items) {
        if (items != null) {
            orderRepo.insert(items);
        }
    }

    @Override
    public void update(Order order) {
        if (order != null) {
            orderRepo.update(order);
        }
    }

    @Override
    public Optional<Order> findById(Long id) {
        if (id != null) {
            return orderRepo.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    @Override
    public void deleteById(Long id) throws CustomUncheckedException {
        if (id != null) {
            orderRepo.deleteById(id);
        }
    }

    @Override
    public void delete(Order order) {
        if (order != null) {
            deleteById(order.getId());
        }
    }

    @Override
    public void printAll() {
        orderRepo.printAll();

    }

    @Override
    public List<Order> search(OrderSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            Optional<Order> foundOrder = findById(searchCondition.getId());
            if (foundOrder.isPresent()) {
                return Collections.singletonList(foundOrder.get());
            } else {
                return Collections.emptyList();
            }

        } else {
            return orderRepo.search(searchCondition);
        }
    }

    @Override
    public void deleteByUserId(Long userId) {
        if (userId != null) {
            orderRepo.deleteById(userId);
        }

    }

    @Override
    public List<Order> getOrdersByUser(Long userId) {
        if (userId != null) {
            return orderRepo.findByUserId(userId);
        } else {
            return Collections.emptyList();
        }
    }

}
