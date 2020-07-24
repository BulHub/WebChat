package ru.bulat.data;

import ru.bulat.model.*;

import java.sql.*;
import java.util.*;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5433/web_chat";
            String password = "543216789";
            String username = "postgres";
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    private Connection getConnection() {
        return connection;
    }

    private static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public static User save(User user) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement("INSERT INTO users(nickname, email, password) VALUES (? , ?, ?) RETURNING id")) {
            settingTheValueForTheRequest(preparedStatement, Arrays.asList(user.getNickname(), user.getEmail(), user.getPassword()));
            user.setId(receivingId(preparedStatement));
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return user;
    }

    public static Optional<User> findByEmail(String email) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement("SELECT id, nickname, email, password, information_id FROM users where email = ?")) {
            preparedStatement.setString(1, email.trim().toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return Optional.ofNullable(User.builder()
                        .id(resultSet.getLong("id"))
                        .nickname(resultSet.getString("nickname"))
                        .email(resultSet.getString("email"))
                        .password(resultSet.getString("password"))
                        .information_id(resultSet.getLong("information_id"))
                        .build());
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return Optional.empty();
    }

    public static void updatePassword(String email, String newPassword) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement("UPDATE users SET password = ? WHERE email = ?")) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public static Information save(Information information) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("INSERT INTO information(name, surname, patronymic, phone, dateofbirth, gender, country, aboutmyself) values(?, ?, ?, ?, ?, ?, ?, ?) RETURNING id")) {
            settingTheValueForTheRequest(preparedStatement, Arrays.asList(information.getName(), information.getSurname(),
                    information.getPatronymic(), information.getPhone(), information.getDateOfBirth(), information.getGender(),
                    information.getCountry(), information.getAboutMySelf()));
            information.setId(receivingId(preparedStatement));
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return information;
    }

    public static Feedback save(Feedback feedback) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement("INSERT INTO feedback(name, email, message) values(?, ?, ?) RETURNING id")) {
            settingTheValueForTheRequest(preparedStatement, Arrays.asList(feedback.getName(), feedback.getEmail(), feedback.getMessage()));
            feedback.setId(receivingId(preparedStatement));
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return feedback;
    }

    public static User_Feedback save(User_Feedback user_feedback) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement("INSERT INTO feedback_user(user_id, feedback_id) VALUES (?, ?)")) {
            preparedStatement.setLong(1, user_feedback.getUser_id());
            preparedStatement.setLong(2, user_feedback.getFeedback_id());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return user_feedback;
    }

    public static Group save(Group group) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("INSERT INTO groups(class) VALUES (?) RETURNING id")) {
            settingTheValueForTheRequest(preparedStatement, Collections.singletonList(group.getName()));
            group.setId(receivingId(preparedStatement));
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return group;
    }

    public static User_Group save(User_Group user_group) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("INSERT INTO user_group(user_id, group_id) VALUES (?, ?)")) {
            preparedStatement.setLong(1, user_group.getUser_id());
            preparedStatement.setLong(2, user_group.getGroup_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return user_group;
    }

    public static Optional<Group> findByName(String group) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("SELECT id, class from groups where class = ?")) {
            preparedStatement.setString(1, group);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.ofNullable(Group.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("class"))
                        .build());
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return Optional.empty();
    }

    public static void updateInformation(long idUser, long idInfo) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("UPDATE users set information_id = ? where id = ?")) {
            preparedStatement.setLong(1, idInfo);
            preparedStatement.setLong(2, idUser);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public static Optional<Information> findById(long id) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("SELECT id, name, surname, patronymic, phone, dateofbirth, gender, country from information where id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return Optional.ofNullable(Information.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .patronymic(resultSet.getString("patronymic"))
                        .phone(resultSet.getString("phone"))
                        .dateOfBirth(resultSet.getString("dateofbirth"))
                        .gender(resultSet.getString("gender"))
                        .country(resultSet.getString("country"))
                        .build());
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return Optional.empty();
    }

    private static void settingTheValueForTheRequest(PreparedStatement preparedStatement, List<String> values) throws SQLException {
        for (int i = 1; i <= values.size(); i++) preparedStatement.setString(i, values.get(i-1));
        preparedStatement.execute();
    }

    private static long receivingId(PreparedStatement preparedStatement) throws SQLException {
        ResultSet lastUpdatedId = preparedStatement.getResultSet();
        if (lastUpdatedId.next()) {
            return lastUpdatedId.getInt(1);
        }
        return 0;
    }
}
