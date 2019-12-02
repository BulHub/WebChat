package ru.bulat.data;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5433/postgres";
            String password = "543216789";
            String username = "postgres";
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public static int writeToDatabaseNewUser(String nickname, String email, String password) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement("INSERT INTO users(nickname, email, password, position) VALUES (? , ?, ?, ?) RETURNING id")) {
            preparedStatement.setString(1, nickname);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, "Client");
            preparedStatement.execute();
            ResultSet lastUpdatedId = preparedStatement.getResultSet();
            if (lastUpdatedId.next()) {
                return lastUpdatedId.getInt(1);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return -1;
    }

    public static int userVerification(String email, String password) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement("SELECT id, password, nickname FROM users where email = ?")) {
            preparedStatement.setString(1, email.trim().toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            while (resultSet.next()) {
                String normalPassword = resultSet.getString("password");
                String nickname = resultSet.getString("nickname");
                int id = resultSet.getInt("id");
                if (encoder.matches(password, normalPassword)) {
                    return id;
                }
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return -1;
    }

    public static void changePassword(String email, String newPassword, String oldPassword) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement("UPDATE users SET password = ? WHERE email = ? and password = ?")) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, oldPassword);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public static int recordingAdditionalUserData(String name, String surname, String patronymic, String phone, String dateOfBirth,
                                                  String gender, String country, String about_myself) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("INSERT INTO informationaboutuser(name, surname, patronymic, phone, dateofbirth, gender, country, aboutmyself) values(?, ?, ?, ?, ?, ?, ?, ?) RETURNING id")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, patronymic);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, dateOfBirth);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, country);
            preparedStatement.setString(8, about_myself);
            preparedStatement.execute();
            ResultSet lastUpdatedId = preparedStatement.getResultSet();
            if (lastUpdatedId.next()) {
                return lastUpdatedId.getInt(1);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return -1;
    }

    public static int recordNewFeedback(String name, String email, String message) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement("INSERT INTO feedback(name, email, message) values(?, ?, ?)RETURNING id")) {
            generalRequestInsert(preparedStatement, name, email, message);
            preparedStatement.execute();
            ResultSet lastUpdatedId = preparedStatement.getResultSet();
            if (lastUpdatedId.next()) {
                return lastUpdatedId.getInt(1);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return -1;
    }

    private static void generalRequestInsert(PreparedStatement preparedStatement, String p1, String p2, String p3) {
        try {
            preparedStatement.setString(1, p1);
            preparedStatement.setString(2, p2);
            preparedStatement.setString(3, p3);
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
        }
    }

    public static void recordingFeedbackWithUser(int idU, int idF) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement("INSERT INTO feedbackusers(id_user, id_feedback) VALUES (?, ?)")) {
            preparedStatement.setInt(1, idU);
            preparedStatement.setInt(2, idF);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public static void writeNewGroup(String group) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("INSERT INTO groups(class) VALUES (?)")) {
            preparedStatement.setString(1, group);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public static void recordGroupsForUsers(int idUser, String group) {
        int idGroup = gettingIdGroup(group);
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("INSERT INTO together(id_user, id_group) VALUES (?, ?)")) {
            preparedStatement.setInt(1, idUser);
            preparedStatement.setInt(2, idGroup);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    private static int gettingIdGroup(String group) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("SELECT id from groups where class = ?")) {
            preparedStatement.setString(1, group);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return -1;
    }

    public static void formFillingRecord(int id_user) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("INSERT INTO profilefilling(field, id_users) VALUES (?, ?)")) {
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, id_user);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public static boolean verificationFormFilling(int id_user) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("SELECT field from profilefilling where id_users = ?")) {
            preparedStatement.setInt(1, id_user);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getBoolean("field");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return false;
    }

    public static void recordInfoForUsers(int idUser, int idInfo) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("INSERT INTO together2(id_user, id_info) VALUES (?, ?)")) {
            preparedStatement.setInt(1, idUser);
            preparedStatement.setInt(2, idInfo);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public static String gettingANickname(int id_user) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("SELECT nickname from users where id = ?")) {
            preparedStatement.setInt(1, id_user);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("nickname");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    public static List<String> receivingAdditionalInformationAboutTheUser(int id_user) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("SELECT name, surname, patronymic, phone, dateofbirth, gender, country from informationaboutuser where id = ?")) {
            preparedStatement.setInt(1, id_user);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String patronymic = resultSet.getString("patronymic");
                String phone = resultSet.getString("phone");
                String dataOfbirth = resultSet.getString("dateofbirth");
                String gender = resultSet.getString("gender");
                String country = resultSet.getString("country");
                List<String> info = new ArrayList<>();
                info.add(name);
                info.add(surname);
                info.add(patronymic);
                info.add(phone);
                info.add(dataOfbirth);
                info.add(gender);
                info.add(country);
                return info;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    public static int receivingAdditionalWithId(int idU) {
        try (PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement
                ("SELECT id_info  from together2 where id_user = ?")) {
            preparedStatement.setInt(1, idU);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("id_info");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return -1;
    }
}
