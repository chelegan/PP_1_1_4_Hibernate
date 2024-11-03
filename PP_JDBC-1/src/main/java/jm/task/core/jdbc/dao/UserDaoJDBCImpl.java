package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        /*
        String sql = "CREATE TABLE IF NOT EXISTS Users " +
                "(Id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                "Name VARCHAR(20), " +
                "LastName VARCHAR(20), " +
                "Age TINYINT)";

        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
            System.out.println("Таблица создана");

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

         */
    }

    @Override
    public void dropUsersTable() {
        /*
        String sql = "DROP TABLE IF EXISTS Users";

        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
            System.out.println("Таблица удалена");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         */
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        /*

        String sql = "INSERT INTO Users(Name, LastName, Age) VALUES (?, ?, ?)";

        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();

            System.out.printf("User c именем %s добавлен \n", name);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         */
    }

    @Override
    public void removeUserById(long id) {
        /*

        String sql = "DELETE FROM Users WHERE Id = ?";

        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            System.out.printf("Пользователь с id %d удален \n", id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         */
    }

    @Override
    public List<User> getAllUsers() {
        /*
        List <User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";

        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("Id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;

         */
        return null;
    }

    @Override
    public void cleanUsersTable() {
        /*
        String sql = "TRUNCATE TABLE Users";

        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
            System.out.println("Таблица очищена");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         */
    }
}
