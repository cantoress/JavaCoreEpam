package common.solutions.service;

import common.business.exception.CustomUncheckedException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseService<ID, T> {

    T insert(T item);

    void insert(Collection<T> items);

    void update(T item);

    Optional<T> findById(ID id);

    List<T> findAll();

    void deleteById(ID id) throws CustomUncheckedException;

    void delete(T item);

    void printAll();
}
