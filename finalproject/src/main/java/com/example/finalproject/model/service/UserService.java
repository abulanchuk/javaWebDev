package com.example.finalproject.model.service;


import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserService<T extends CustomEntity> {
    List<T> findAll() throws ServiceException;

    Optional<T> findById(Long id) throws ServiceException;

    boolean deleteById(Long id) throws ServiceException;

    T insertNewEntity(CustomEntity... entities) throws ServiceException;

    boolean updatePasswordByLogin(String login, String oldPassword, String newPassword) throws ServiceException;

    boolean updateLogin(String currentLogin, String newLogin, Long id) throws ServiceException;

    List<User> findAllUsersByRole(UserRole role) throws ServiceException;

    List<User> findAllUsersWithSuchSurname(String surname) throws ServiceException;

    boolean updateSurname(Long id, String newSurname) throws ServiceException;

    boolean updateName(String newName, Long id) throws ServiceException;

    boolean updatePhoneNumber(String newPhoneNumber, Long id) throws ServiceException;

    Optional<User> findUserByPhoneNumber(String phone) throws ServiceException;

    Optional<User> findUserByLoginAndPassword(String login, String password) throws ServiceException;
}
