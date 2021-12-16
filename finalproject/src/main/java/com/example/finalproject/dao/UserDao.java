package com.example.finalproject.dao;

import com.example.finalproject.entity.User;
import com.example.finalproject.entity.UserRole;
import com.example.finalproject.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao extends BaseDao<User> {
    boolean updatePasswordByLogin(String login, String oldPassword, String newPassword) throws DaoException;
    boolean updateLogin(String currentLogin, String newLogin) throws DaoException;
    List<User> findAllUsersWithRole(UserRole role) throws DaoException;
    List<User> findAllUsersWithSuchSurname(String surname) throws DaoException;
    boolean updateSurname(String currentSurname, String newSurname) throws DaoException;
    boolean updateName(String currentName, String newName) throws DaoException;
    Optional<User> findUserByPhoneNumber(String phone) throws DaoException;
    Optional<User> findUserByLogin(String login) throws DaoException;
}
