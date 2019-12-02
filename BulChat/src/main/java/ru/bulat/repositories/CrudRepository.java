package ru.bulat.repositories;

import java.util.Collection;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    Optional<ID> create(T t);
    void update(T t);
    void delete(ID id);
    Optional<T> findOne(ID id);
    Collection<T> findAll();
}
