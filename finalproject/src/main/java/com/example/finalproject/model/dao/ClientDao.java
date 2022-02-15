package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Client;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.entity.UserRole;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * The interface Client dao.
 */
public interface ClientDao extends BaseDao<Client> {
    /**
     * Update email boolean.
     *
     * @param id       the client's id
     * @param newEmail the new email
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updateEmail(Long id,String newEmail) throws DaoException;

    /**
     * Update cash in bank account boolean.
     *
     * @param id           the client's id
     * @param howMuchToAdd  how much money to add
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updateCashInBankAccount (Long id, BigDecimal howMuchToAdd) throws DaoException;

    /**
     * Withdrawal cash from bank account boolean.
     *
     * @param id                  the client's id
     * @param howMuchToWithdrawal how much money to withdrawal after booking room
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean withdrawalCashFromBankAccount (Long id, BigDecimal howMuchToWithdrawal) throws DaoException;

    /**
     * Update passport number boolean.
     *
     * @param oldPasswordNumber the old password number
     * @param newPasswordNumber the new password number
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updatePassportNumber(String oldPasswordNumber,String newPasswordNumber) throws DaoException;

    /**
     * Find by id user optional.
     *
     * @param id the user's id
     * @return the optional user
     * @throws DaoException the dao exception
     */
    Optional<Client> findByIdUser(Long id) throws DaoException;

    /**
     * Find by email optional.
     *
     * @param email the client's email
     * @return the optional client
     * @throws DaoException the dao exception
     */
    Optional<Client> findByEmail(String email) throws DaoException;

    /**
     * Update client boolean.
     *
     * @param idUser         the id user
     * @param newName        the new name
     * @param newSurname     the new surname
     * @param newPhoneNumber the new phone number
     * @param email          the new email
     * @param passportNumber the new passport number
     * @return the successful result or not after updating (boolean)
     * @throws DaoException the dao exception
     */
    boolean updateClient(Long idUser, String newName, String newSurname, String newPhoneNumber, String email, String passportNumber) throws DaoException;

    /**
     * Delete by login boolean.
     *
     * @param login the client's login for deleting
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean deleteByLogin(String login) throws DaoException;

    /**
     * Update password boolean.
     *
     * @param id          the user's id
     * @param oldPassword the old password
     * @param newPassword the new password
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updatePassword(Long id, String oldPassword, String newPassword) throws DaoException;
}
