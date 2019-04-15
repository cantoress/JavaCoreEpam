package user.service.impl;

import common.business.exception.CustomUncheckedException;
import order.repo.OrderRepo;
import user.domain.User;
import user.exception.DeleteUserException;
import user.repo.UserRepo;
import user.search.UserSearchCondition;
import user.service.UserService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static user.exception.UserExceptionInformation.DELETE_USED_USER;

public class UserDefaultService implements UserService {

    private UserRepo userRepo;
    private OrderRepo orderRepo;

    public UserDefaultService(UserRepo userRepo, OrderRepo orderRepo) {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public User insert(User user) {
        if (user != null) {
            userRepo.insert(user);
        }
        return user;
    }

    @Override
    public void insert(Collection<User> items) {
        if (items != null) {
            userRepo.insert(items);
        }
    }

    @Override
    public void update(User user) {
        if (user != null) {
            userRepo.update(user);
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        if (id != null) {
            return userRepo.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void deleteById(Long id) throws CustomUncheckedException {
        if (id != null) {
            int ordersWithUser = orderRepo.countByUser(id);
            if (ordersWithUser != 0) {
                throw new DeleteUserException(DELETE_USED_USER);
            } else {
                userRepo.deleteById(id);
            }
        }
    }

    @Override
    public void delete(User user) {
        if (user != null) {
            deleteById(user.getId());
        }
    }

    @Override
    public void printAll() {
        userRepo.printAll();
    }

    @Override
    public List<? extends User> search(UserSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            Optional<User> foundUser = findById(searchCondition.getId());
            if (foundUser.isPresent()) {
                return Collections.singletonList(foundUser.get());
            } else {
                return Collections.emptyList();
            }

        } else {
            return userRepo.search(searchCondition);
        }
    }
}
