package ru.bulat.repositories;

import java.util.Collection;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Long> {
    @Override
    Optional<Long> create(User user);

    @Override
    void update(User user);

    @Override
    void delete(Long id);

    @Override
    Optional<User> findOne(Long id);

    @Override
    Collection<User> findAll();
}
