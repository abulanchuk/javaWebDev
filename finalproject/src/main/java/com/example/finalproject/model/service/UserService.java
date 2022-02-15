package com.example.finalproject.model.service;


import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;

import java.util.List;
import java.util.Optional;

/**
 * The interface User service.
 *
 * @param <T> the type parameter
 */
public interface UserService<T extends CustomEntity> {
    /**
     * Find all list.
     *
     * @return the list of users
     * @throws ServiceException the service exception
     */
    List<T> findAll() throws ServiceException;

    /**
     * Find by id optional.
     *
     * @param id the user's id
     * @return the optional user
     * @throws ServiceException the service exception
     */
    Optional<T> findById(Long id) throws ServiceException;

    /**
     * Delete by id boolean.
     *
     * @param id the user's id
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean deleteById(Long id) throws ServiceException;

    /**
     * Insert new user.
     *
     * @param entity the entity
     * @return the new user
     * @throws ServiceException the service exception
     */
    T insertNewEntity(CustomEntity entity) throws ServiceException;

    /**
     * Update password by login boolean.
     *
     * @param login       the user's login
     * @param oldPassword the user's old password
     * @param newPassword the user's new password
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean updatePasswordByLogin(String login, String oldPassword, String newPassword) throws ServiceException;

    /**
     * Update login boolean.
     *
     * @param currentLogin the current login
     * @param newLogin     the new login
     * @param id           the user's id
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean updateLogin(String currentLogin, String newLogin, Long id) throws ServiceException;

    /**
     * Find all users by role list.
     *
     * @param role the role
     * @return the list of user's selected by role
     * @throws ServiceException the service exception
     */
    List<User> findAllUsersByRole(UserRole role) throws ServiceException;

    /**
     * Find all users with such surname list.
     *
     * @param surname the surname
     * @return the list selected by surname
     * @throws ServiceException the service exception
     */
    List<User> findAllUsersWithSuchSurname(String surname) throws ServiceException;

    /**
     * Update surname boolean.
     *
     * @param id         the id user
     * @param newSurname the new surname
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean updateSurname(Long id, String newSurname) throws ServiceException;

    /**
     * Update name boolean.
     *
     * @param newName the new name
     * @param id      the id user
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean updateName(String newName, Long id) throws ServiceException;

    /**
     * Update phone number boolean.
     *
     * @param newPhoneNumber the new phone number
     * @param id             the id user
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean updatePhoneNumber(String newPhoneNumber, Long id) throws ServiceException;

    /**
     * Update user boolean.
     *
     * @param id             the id
     * @param newPassword    the new password
     * @param newName        the new name
     * @param newSurname     the new surname
     * @param newPhoneNumber the new phone number
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean updateUser(Long id, String newPassword, String newName, String newSurname, String newPhoneNumber) throws ServiceException;

    /**
     * Find user by phone number optional.
     *
     * @param phone the phone
     * @return the optional user if exists with this phone number
     * @throws ServiceException the service exception
     */
    Optional<User> findUserByPhoneNumber(String phone) throws ServiceException;

    /**
     * Find user by login and password optional.
     *
     * @param login    the login
     * @param password the password
     * @return the optional user with such login and password
     * @throws ServiceException the service exception
     */
    Optional<User> findUserByLoginAndPassword(String login, String password) throws ServiceException;

    /**
     * Find user by login optional.
     *
     * @param login the login
     * @return the optional user with such login
     * @throws ServiceException the service exception
     */
    Optional<User> findUserByLogin(String login) throws ServiceException;
}
