package com.example.finalproject.dao;

import com.example.finalproject.entity.Client;
import com.example.finalproject.exception.DaoException;

import java.math.BigDecimal;

public interface ClientDao extends BaseDao<Client> {
    boolean updateEmail(String oldEmail,String newEmail) throws DaoException;
    BigDecimal checkCashInBankAccount (String passwordNumber) throws DaoException;
    BigDecimal updateCashInBankAccount (BigDecimal oldCash,BigDecimal howMuchToAdd) throws DaoException; //todo
    boolean updatePasswordNumber(String oldPasswordNumber,String newPasswordNumber) throws DaoException;
}
