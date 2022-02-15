package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;
import com.example.finalproject.exception.DaoException;

import java.util.List;
import java.util.Optional;

/**
 * The interface User dao.
 */
public interface UserDao extends BaseDao<User> {
    /**
     * Update password by login boolean.
     *
     * @param login       the login
     * @param oldPassword the old password
     * @param newPassword the new password
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updatePasswordByLogin(String login, String oldPassword, String newPassword) throws DaoException;

    /**
     * Update login boolean.
     *
     * @param currentLogin the current login
     * @param newLogin     the new login
     * @param id           the user's id
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updateLogin(String currentLogin, String newLogin, Long id) throws DaoException;

    /**
     * Find all users by role list.
     *
     * @param role the role
     * @return the list of users by role
     * @throws DaoException the dao exception
     */
    List<User> findAllUsersByRole(UserRole role) throws DaoException;

    /**
     * Find all users with such surname list.
     *
     * @param surname the surname
     * @return the list of users with such surname
     * @throws DaoException the dao exception
     */
    List<User> findAllUsersWithSuchSurname(String surname) throws DaoException;

    /**
     * Update surname boolean.
     *
     * @param id         the user's id
     * @param newSurname the new surname
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updateSurname(Long id, String newSurname) throws DaoException;

    /**
     * Update name boolean.
     *
     * @param newName the new name
     * @param id      the user's id
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updateName(String newName, Long id) throws DaoException;

    /**
     * Update phone number boolean.
     *
     * @param newPhoneNumber the new phone number
     * @param id             the user's id
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updatePhoneNumber(String newPhoneNumber, Long id) throws DaoException;

    /**
     * Update user boolean.
     *
     * @param id             the user's id
     * @param newPassword    the new password
     * @param newName        the new name
     * @param newSurname     the new surname
     * @param newPhoneNumber the new phone number
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updateUser(Long id,String newPassword, String newName, String newSurname, String newPhoneNumber) throws DaoException;

    /**
     * Find user by phone number optional.
     *
     * @param phone the phone
     * @return the optional user after finding by phone number
     * @throws DaoException the dao exception
     */
    Optional<User> findUserByPhoneNumber(String phone) throws DaoException;

    /**
     * Find user by login optional.
     *
     * @param login the login
     * @return the optional user after finding by login
     * @throws DaoException the dao exception
     */
    Optional<User> findUserByLogin(String login) throws DaoException;

    /**
     * Find user by login and password optional.
     *
     * @param login    the login
     * @param password the password
     * @return the optional user after finding by login and password
     * @throws DaoException the dao exception
     */
    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;
}
