package com.example.finalproject.model.service;

import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.CustomEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ClientService <T extends CustomEntity>{
    List<T> findAll() throws ServiceException;
    Optional<T> findById(Long id) throws ServiceException;
    Optional<Client> findByEmail(String email) throws ServiceException;
    Optional<T> findByIdUser(Long id) throws ServiceException;
    boolean deleteById(Long id) throws ServiceException;
    void deleteByLogin(String login) throws ServiceException;
    T insertNewEntity(CustomEntity... entities) throws ServiceException;
    boolean updateEmail(Long id,String newEmail) throws ServiceException;
    boolean updatePassword(Long id, String oldPassword, String newPassword) throws ServiceException;
    boolean updateCashInBankAccount (Long id, String howMuchToAdd) throws ServiceException;
    boolean withdrawalCashFromBankAccount (Long id, String howMuchToWithdrawal) throws ServiceException;
    boolean updatePassportNumber(String oldPasswordNumber,String newPasswordNumber) throws ServiceException;
    boolean updateClient(Long idUser, String newName, String newSurname, String newPhoneNumber, String email, String passportNumber) throws ServiceException;
}
