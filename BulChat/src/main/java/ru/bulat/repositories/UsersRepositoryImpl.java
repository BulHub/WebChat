package ru.bulat.repositories;

import ru.bulat.data.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

public class UsersRepositoryImpl implements UsersRepository {

    @Override
    public Optional<Long> create(User user) {
        try(Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into users(nickname, email, password, position) values(?, ?, ?) RETURNING id ")){
            preparedStatement.setString(1, user.getNickname());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPosition());
            ResultSet rs = preparedStatement.executeQuery();
            Optional<Long> id = Optional.empty();
            while (rs.next()) {
                id = Optional.of(rs.getLong("id"));
            }
            return id;
        }catch (SQLException ex){
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
            throw new IllegalStateException("Добавление пользователя не удалось");
        }
    }

    @Override
    public void update(User user) {
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE users SET email = ?, password =? WHERE id = ?")) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
            throw new IllegalStateException("Не удалось провести запрос корректно");
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE users WHERE id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
            throw new IllegalStateException("Не удалось провести запрос корректно");
        }
    }

    @Override
    public Optional<User> findOne(Long id) {
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            Optional<User> user = Optional.empty();
            while (rs.next()) {
                user = Optional.of(userRowMapper.mapRow(rs));
            }
            return user;
        } catch (SQLException ex) {
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
            throw new IllegalStateException("Не удалось выполнить запрос");
        }
    }

    @Override
    public Collection<User> findAll() {
        Collection<User> collection = new LinkedList<>();
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM users")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                collection.add(userRowMapper.mapRow(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new IllegalStateException("Не удалось выполнить запрос");
        }
        return collection;
    }

    private RowMapper<User> userRowMapper = rs -> {
        try {
            return new User(
                    rs.getLong("id"),
                    rs.getString("nickname"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("position")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    };
}
