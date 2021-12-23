package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;
import com.example.finalproject.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao extends BaseDao<User> {
    boolean updatePasswordByLogin(String login, String oldPassword, String newPassword) throws DaoException;

    boolean updateLogin(String currentLogin, String newLogin) throws DaoException;

    List<User> findAllUsersByRole(UserRole role) throws DaoException;

    List<User> findAllUsersByName(String name) throws DaoException;

    List<User> findAllUsersWithSuchSurname(String surname) throws DaoException;

    boolean updateSurname(String currentSurname, String newSurname) throws DaoException;

    boolean updateName(String currentName, String newName) throws DaoException;

    boolean updatePhoneNumber(String newPhoneNumber) throws DaoException;

    Optional<User> findUserByPhoneNumber(String phone) throws DaoException;

    Optional<User> findUserByLogin(String login) throws DaoException;
}
