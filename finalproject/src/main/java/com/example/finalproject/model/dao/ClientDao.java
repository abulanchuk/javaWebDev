package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Client;
import com.example.finalproject.exception.DaoException;

import java.math.BigDecimal;

public interface ClientDao extends BaseDao<Client> {
    boolean updateEmail(Long id,String newEmail) throws DaoException;
    boolean updateCashInBankAccount (Long id, BigDecimal howMuchToAdd) throws DaoException;
    boolean updatePassportNumber(String oldPasswordNumber,String newPasswordNumber) throws DaoException;
}
