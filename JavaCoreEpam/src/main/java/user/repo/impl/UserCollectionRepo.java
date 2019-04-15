package user.repo.impl;

import storage.SequenceIDGenerator;
import user.domain.User;
import user.repo.UserRepo;
import user.search.UserSearchCondition;

import java.util.*;

import static storage.Storage.userList;

public class UserCollectionRepo implements UserRepo {


    @Override
    public User insert(User user) {
        user.setId(SequenceIDGenerator.getNextID());
        userList.add(user);
        return user;
    }

    @Override
    public void insert(Collection<User> items) {
        for (User user : items) {
            insert(user);
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public Optional<User> findById(Long id) {
        for (User user : userList) {
            if ((user != null) && (user.getId().equals(id))) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void deleteById(Long id) {
        Optional<User> userToRemove = findById(id);
        userToRemove.ifPresent(user -> userList.remove(user));
    }

    @Override
    public void printAll() {
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Override
    public List<? extends User> search(UserSearchCondition searchCondition) {
        List<User> foundUsers = new ArrayList<>();

        for (User user : userList) {
            boolean found = true;

            if (searchCondition.searchByFirstName()) {
                found = searchCondition.getFirstName().equals(user.getFirstName());
            }

            if (found && searchCondition.searchByLastName()) {
                found = searchCondition.getLastName().equals(user.getLastName());
            }

            if (found) {
                foundUsers.add(user);
            }
        }

        return foundUsers;
    }
}
