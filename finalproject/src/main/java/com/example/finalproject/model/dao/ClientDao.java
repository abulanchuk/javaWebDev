package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Client;
import com.example.finalproject.exception.DaoException;

import java.math.BigDecimal;

public interface ClientDao extends BaseDao<Client> {
    boolean updateEmail(Long id,String newEmail) throws DaoException;
    BigDecimal checkCashInBankAccount (long idClient) throws DaoException;
    boolean updateCashInBankAccount (Long id, BigDecimal howMuchToAdd) throws DaoException;
    boolean updatePasswordNumber(String oldPasswordNumber,String newPasswordNumber) throws DaoException;
}