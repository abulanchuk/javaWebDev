package com.example.finalproject.model.service;

import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.CustomEntity;

import java.util.List;
import java.util.Optional;

/**
 * The interface Client service.
 *
 * @param <T> the type parameter
 */
public interface ClientService <T extends CustomEntity>{
    /**
     * Find all list.
     *
     * @return the list of clients
     * @throws ServiceException the service exception
     */
    List<T> findAll() throws ServiceException;

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional client if found by id
     * @throws ServiceException the service exception
     */
    Optional<T> findById(Long id) throws ServiceException;

    /**
     * Find by email optional.
     *
     * @param email the email
     * @return the optional client if found by email
     * @throws ServiceException the service exception
     */
    Optional<Client> findByEmail(String email) throws ServiceException;

    /**
     * Find by id user optional.
     *
     * @param id the id
     * @return the optional client if found by user's id
     * @throws ServiceException the service exception
     */
    Optional<T> findByIdUser(Long id) throws ServiceException;

    /**
     * Delete by id boolean.
     *
     * @param id the id
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean deleteById(Long id) throws ServiceException;

    /**
     * Delete by login.
     *
     * @param login the login
     * @throws ServiceException the service exception
     */
    boolean deleteByLogin(String login) throws ServiceException;

    /**
     * Insert new entity t.
     *
     * @param entity the entity
     * @return the new created client
     * @throws ServiceException the service exception
     */
    T insertNewEntity(CustomEntity entity) throws ServiceException;

    /**
     * Update email boolean.
     *
     * @param id       the id
     * @param newEmail the new email
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean updateEmail(Long id,String newEmail) throws ServiceException;

    /**
     * Update password boolean.
     *
     * @param id          the id
     * @param oldPassword the old password
     * @param newPassword the new password
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean updatePassword(Long id, String oldPassword, String newPassword) throws ServiceException;

    /**
     * Update cash in bank account boolean.
     *
     * @param id           the id
     * @param howMuchToAdd the how much to add
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean updateCashInBankAccount (Long id, String howMuchToAdd) throws ServiceException;

    /**
     * Withdrawal cash from bank account boolean.
     *
     * @param id                  the id
     * @param howMuchToWithdrawal how much to withdrawal from bank account
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean withdrawalCashFromBankAccount (Long id, String howMuchToWithdrawal) throws ServiceException;

    /**
     * Update passport number boolean.
     *
     * @param oldPasswordNumber the old password number
     * @param newPasswordNumber the new password number
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean updatePassportNumber(String oldPasswordNumber,String newPasswordNumber) throws ServiceException;

    /**
     * Update client boolean.
     *
     * @param idUser         the id user
     * @param newName        the new name
     * @param newSurname     the new surname
     * @param newPhoneNumber the new phone number
     * @param email          the new email
     * @param passportNumber the new passport number
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean updateClient(Long idUser, String newName, String newSurname, String newPhoneNumber, String email, String passportNumber) throws ServiceException;
}
