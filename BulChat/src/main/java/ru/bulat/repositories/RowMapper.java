package ru.bulat.repositories;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T mapRow(ResultSet rs);
}
