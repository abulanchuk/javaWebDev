package com.example.finalproject.model.service;


import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> signIn(String login, String password) throws ServiceException;
}
