package common.solutions.repo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseRepo<ID, T> {

    T insert(T item);

    void insert(Collection<T> items);

    void update(T item);

    Optional<T> findById(ID id);

    List<T> findAll();

    void deleteById(ID id);

    void printAll();
}
