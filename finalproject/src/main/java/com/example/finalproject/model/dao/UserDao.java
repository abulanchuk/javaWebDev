package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;
import com.example.finalproject.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao extends BaseDao<User> {
    boolean updatePasswordByLogin(String login, String oldPassword, String newPassword) throws DaoException;

    boolean updateLogin(String currentLogin, String newLogin, Long id) throws DaoException;

    List<User> findAllUsersByRole(UserRole role) throws DaoException;

    List<User> findAllUsersWithSuchSurname(String surname) throws DaoException;

    boolean updateSurname(Long id, String newSurname) throws DaoException;

    boolean updateName(String newName, Long id) throws DaoException;

    boolean updatePhoneNumber(String newPhoneNumber, Long id) throws DaoException;

    Optional<User> findUserByPhoneNumber(String phone) throws DaoException;
}
