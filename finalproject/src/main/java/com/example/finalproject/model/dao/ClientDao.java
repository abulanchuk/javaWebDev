package com.example.finalproject.model.dao;

import com.example.finalproject.entity.Client;
import com.example.finalproject.exception.DaoException;

import java.math.BigDecimal;

public interface ClientDao extends BaseDao<Client> {
    boolean updateEmail(String oldEmail,String newEmail) throws DaoException;
    BigDecimal checkCashInBankAccount (long idClient) throws DaoException;
    BigDecimal updateCashInBankAccount (BigDecimal howMuchToAdd) throws DaoException;
    boolean updatePasswordNumber(String oldPasswordNumber,String newPasswordNumber) throws DaoException;
}
