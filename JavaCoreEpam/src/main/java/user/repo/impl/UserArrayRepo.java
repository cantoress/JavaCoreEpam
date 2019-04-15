package user.repo.impl;

import storage.SequenceIDGenerator;
import user.domain.User;
import user.repo.UserRepo;
import user.search.UserSearchCondition;

import java.util.*;

import static storage.Storage.userArray;

public class UserArrayRepo implements UserRepo {


    private int userIndex = 0;

    @Override
    public User insert(User user) {
        if (userIndex == userArray.length) {
            User[] newUserArray = new User[userArray.length * 2];
            System.arraycopy(userArray, 0, newUserArray, 0, userArray.length);
            userArray = newUserArray;
        }
        userIndex++;
        user.setId(SequenceIDGenerator.getNextID());
        userArray[userIndex] = user;

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
        int index = findUserIndexFromID(id);
        if (index != -1) {
            return Optional.of(userArray[index]);
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(Arrays.asList(userArray));
    }

    @Override
    public void deleteById(Long id) {
        int index = findUserIndexFromID(id);
        if (index != -1) {
            System.arraycopy(userArray, index + 1, userArray, index, userArray.length - index - 1);
        }
    }

    @Override
    public void printAll() {
        for (User user : userArray) {
            System.out.println(user);
        }
    }

    @Override
    public List<? extends User> search(UserSearchCondition searchCondition) {
        User[] foundUsers = new User[userArray.length];
        int resultIndex = 0;

        for (User user : userArray) {
            boolean found = true;

            if (searchCondition.searchByFirstName()) {
                found = searchCondition.getFirstName().equals(user.getFirstName());
            }

            if (found && searchCondition.searchByLastName()) {
                found = searchCondition.getLastName().equals(user.getLastName());
            }

            if (found) {
                foundUsers[resultIndex] = user;
                resultIndex++;
            }
        }
        if (resultIndex != 0) {
            User[] resultUsers = new User[resultIndex];
            System.arraycopy(foundUsers, 0, resultUsers, 0, resultIndex);
            return new ArrayList<>(Arrays.asList(resultUsers));
        }

        return Collections.emptyList();
    }

    private int findUserIndexFromID(long id) {
        for (int i = 0; i < userArray.length; i++) {
            User user = userArray[i];
            if ((user != null) && (user.getId().equals(id))) {
                return i;
            }
        }
        return -1;
    }

}