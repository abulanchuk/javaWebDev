package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.dao.UserDao;
import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.mapper.impl.UserCreator;
import com.example.finalproject.model.pool.ConnectionPool;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SQL_SELECT_ALL_USERS = """
            SELECT id_user, login, password, role, name, surname, phone_number FROM users""";
    private static final String SQL_SELECT_USER_BY_ID = """
            SELECT id_user, login, password, role, name, surname, phone_number FROM users WHERE id_user =?""";
    private static final String SQL_DELETE_USER_BY_ID = """
            DELETE users FROM users WHERE id_user = ?""";
    private static final String SQL_INSERT_USER = """
            INSERT INTO users (login, password, role, name, surname, phone_number) VALUES (?,?,?,?,?,?)""";
    private static final String SQL_UPDATE_PASSWORD_BY_LOGIN = """
            UPDATE users SET password = ? WHERE login = ? AND password =?""";
    private static final String SQL_UPDATE_USER = """
            UPDATE users SET login = ?, password = ?, name = ?, surname = ?, phone_number = ? WHERE id_user = ?""";
    private static final String SQL_UPDATE_LOGIN = """
            UPDATE users SET login = ? WHERE login = ? AND id_user =? """;
    private static final String SQL_SELECT_USERS_BY_ROLE = """
            SELECT id_user, login, password, role, name, surname, phone_number FROM users WHERE role = ?""";
    private static final String SQL_SELECT_USERS_BY_SURNAME = """
            SELECT id_user, login, password, role, name, surname, phone_number FROM users WHERE surname = ?""";
    private static final String SQL_UPDATE_SURNAME = """
            UPDATE users SET surname = ? WHERE id_user = ?""";
    private static final String SQL_UPDATE_NAME = """
            UPDATE users SET name = ? WHERE id_user = ?""";
    private static final String SQL_UPDATE_PHONE_NUMBER = """
            UPDATE users SET phone_number = ? WHERE id_user = ?""";
    private static final String SQL_SELECT_USER_BY_PHONE_NUMBER = """
            SELECT id_user, login, password, role, name, surname, phone_number FROM users WHERE phone_number = ?""";
    private static final String SQL_SELECT_USER_BY_LOGIN = """
            SELECT id_user, login, password, role, name, surname, phone_number FROM users WHERE login = ?""";
    private static final String SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD = """
            SELECT id_user, login, password, role, name, surname, phone_number WHERE login = ? AND password = ?""";
    private UserCreator userCreator = new UserCreator();
    private static UserDaoImpl instance;

    public UserDaoImpl() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public List<User> findAll() throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS)) {
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = userCreator.create(resultSet);
                users.add(user);
            }
            logger.log(Level.DEBUG, "findAll method by users was completed successfully. " + users.size() + " were found");
            return users;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find users. Database access error:", e);
            throw new DaoException("Impossible to find users. Database access error:", e);
        }
    }


    @Override
    public Optional<User> findById(Long id) throws DaoException {
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = userCreator.create(resultSet);
                userOptional = Optional.of(user);
            }
            logger.log(Level.DEBUG, "findById method from UserDaoImpl was completed successfully."
                    + ((userOptional.isPresent()) ? " User with id " + id + " was found" : " User with id " + id + " don't exist"));
            return userOptional;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find user by id. Database access error:", e);
            throw new DaoException("Impossible to find user by id. Database access error:", e);
        }
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER_BY_ID)) {
            statement.setLong(1, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to delete user with id: " + id, e);
            throw new DaoException("Impossible to delete user with id: " + id, e);
        }
    }

    @Override
    public User insertNewEntity(CustomEntity... entity) throws DaoException {
        if (entity.length != 1){
            throw  new DaoException("Expected 1 argument, got " + entity.length);
        }

        if (!(entity[0] instanceof User)) {
            throw new DaoException("Expected type User, got " + entity[0].getClass());
        }

        User user = (User) entity[0];

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole().toString());
            statement.setString(4, user.getName());
            statement.setString(5, user.getSurname());
            statement.setString(6, user.getPhoneNumber());

            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    long idUser = resultSet.getLong(1);
                    user.setIdUser(idUser);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("create() - Failed to create user: ", e);
        }
        logger.log(Level.DEBUG, "User successfully created: " + user);
        return user;
    }

    @Override
    public boolean updatePasswordByLogin(String login, String oldPassword, String newPassword) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PASSWORD_BY_LOGIN)) {
            statement.setString(1, newPassword);
            statement.setString(2, login);
            statement.setString(3, oldPassword);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "Password didn't update with login " + login);
                return false;
            }
            logger.log(Level.DEBUG, "Password with login " + login + "updated successfully");
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update user's password. Database access error:", e);
            throw new DaoException("Impossible to update user's password. Database access error:", e);
        }
    }

    @Override
    public boolean updateLogin(String currentLogin, String newLogin, Long id) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_LOGIN)) {
            statement.setString(1, newLogin);
            statement.setString(2, currentLogin);
            statement.setLong(3, id);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "Login didn't update with current login " + currentLogin);
                return false;
            }
            logger.log(Level.DEBUG, "Login " + currentLogin + "updated successfully");
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update user's login. Database access error:", e);
            throw new DaoException("Impossible to update user's login. Database access error:", e);
        }
    }

    @Override
    public List<User> findAllUsersByRole(UserRole role) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USERS_BY_ROLE)) {
            statement.setString(1, role.toString());
            ResultSet resultSet = statement.executeQuery();

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = userCreator.create(resultSet);
                users.add(user);
            }
            logger.log(Level.DEBUG, "findAllUsersByRole method by rooms was completed successfully. " + users.size() + " were found");
            return users;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find users by role. Database access error:", e);
            throw new DaoException("Impossible to find users by role. Database access error:", e);
        }
    }


    @Override
    public List<User> findAllUsersWithSuchSurname(String surname) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USERS_BY_SURNAME)) {
            statement.setString(1, surname);
            ResultSet resultSet = statement.executeQuery();

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = userCreator.create(resultSet);
                users.add(user);
            }
            logger.log(Level.DEBUG, "findAllUsersWithSuchSurname method by rooms was completed successfully. " + users.size() + " were found");
            return users;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find users by such surname. Database access error:", e);
            throw new DaoException("Impossible to find users by such surname. Database access error:", e);
        }
    }

    @Override
    public boolean updateSurname(Long id, String newSurname) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_SURNAME)) {
            statement.setString(1, newSurname);
            statement.setLong(2, id);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "User's surname didn't update with id " + id);
                return false;
            }
            logger.log(Level.DEBUG, "Result of update surname for client with id " + id + " is " + newSurname);
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to updating surname. Database access error:", e);
            throw new DaoException("Impossible to update surname. Database access error:", e);
        }
    }

    @Override
    public boolean updateName(String newName, Long id) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_NAME)) {
            statement.setString(1, newName);
            statement.setLong(2, id);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "User's name didn't update with id " + id);
                return false;
            }
            logger.log(Level.DEBUG, "Result of updating name for client with id " + id + " is " + newName);
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update name. Database access error:", e);
            throw new DaoException("Impossible to update name. Database access error:", e);
        }
    }

    @Override
    public boolean updatePhoneNumber(String newPhoneNumber, Long id) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PHONE_NUMBER)) {
            statement.setString(1, newPhoneNumber);
            statement.setLong(2, id);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "User's phone number didn't update with id " + id);
                return false;
            }
            logger.log(Level.DEBUG, "Result of updating phone number for client with id " + id + " is " + newPhoneNumber);
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update phone number. Database access error:", e);
            throw new DaoException("Impossible to update phone number. Database access error:", e);
        }
    }

    @Override
    public boolean updateUser(Long id, String newLogin, String newPassword, String newName, String newSurname, String newPhoneNumber) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER)) {
            statement.setString(1, newLogin);
            statement.setString(2, newPassword);
            statement.setString(3, newName);
            statement.setString(4, newSurname);
            statement.setString(5, newPhoneNumber);
            statement.setLong(6, id);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "User's fields didn't update with id " + id);
                return false;
            }
            logger.log(Level.DEBUG, "Successfully updated user's fields");
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update user's fields. Database access error:", e);
            throw new DaoException("Impossible to update user's fields. Database access error:", e);
        }
    }

    @Override
    public Optional<User> findUserByPhoneNumber(String phone) throws DaoException {
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_PHONE_NUMBER)) {
            statement.setString(1, phone);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = userCreator.create(resultSet);
                userOptional = Optional.of(user);
            }
            logger.log(Level.DEBUG, "findUserByPhoneNumber method from UserDaoImpl was completed successfully."
                    + ((userOptional.isPresent()) ? " User with phone number " + phone + " was found" : " User with phone number " + phone + " don't exist"));
            return userOptional;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find user by phone number. Database access error:", e);
            throw new DaoException("Impossible to find user by phone number. Database access error:", e);
        }
    }

    @Override
    public Optional<User> findUserByLogin(String login) throws DaoException {
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = userCreator.create(resultSet);
                userOptional = Optional.of(user);
            }
            logger.log(Level.DEBUG, "findUserByLogin method from UserDaoImpl was completed successfully."
                    + ((userOptional.isPresent()) ? " User with login number " + login + " was found" : " User with login number " + login + " don't exist"));
            return userOptional;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find user by phone number. Database access error:", e);
            throw new DaoException("Impossible to find user by phone number. Database access error:", e);
        }
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = userCreator.create(resultSet);
                userOptional = Optional.of(user);
            }
            logger.log(Level.DEBUG, "findUserByPhoneNumber method from UserDaoImpl was completed successfully."
                    + ((userOptional.isPresent()) ? " User by login and password was found" : "by login and password wasn't found"));
            return userOptional;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find user by phone number. Database access error:", e);
            throw new DaoException("Impossible to find user by phone number. Database access error:", e);
        }
    }
}
