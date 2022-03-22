package com.example.finalproject.model.dao.impl;

import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.UserRole;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


public class ClientDaoImplTest {
    public static final long CLIENT_ID = 1;
    public static final long USER_ID = 13;
    public static final String CLIENT_EMAIL = "alica@gmail.com";
    private static final boolean EXPECTED_ROWS_UPDATED = true;
    private Client actual;

    @Mock
    private ClientDaoImpl clientDaoMock;
    private Client expectedClient;
    private Client firstClient;
    private Client secondClient;
    List<Client> expectedClients;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        expectedClient = new Client(13, "alicaJein", "34-fd,thkdefg", UserRole.CLIENT, "Alica", "Jein", "296785500", 1, "MP7896754", "alica@gmail.com", new BigDecimal(23400));
        firstClient = new Client(13, "alicaJein", "34-fd,thkdefg", UserRole.CLIENT, "Alica", "Jein", "296785500", 1, "MP7896754", "alica@gmail.com", new BigDecimal(23400));
        secondClient = new Client(14, "piterLo1", "78Tpolk,76", UserRole.CLIENT, "Piter", "Lopino", "448794411", 2, "MP9875543", "piter12@gmail.com", new BigDecimal(34000));
        expectedClients = List.of(firstClient, secondClient);
    }


    @Test
    public void testFindAll() throws DaoException {
        when(clientDaoMock.findAll()).thenReturn(expectedClients);
        List<Client> actual = clientDaoMock.findAll();
        assertThat(actual).containsExactly(firstClient, secondClient);
    }

    @Test
    public void testFindById() throws DaoException {
        when(clientDaoMock.findById(CLIENT_ID)).thenReturn(Optional.ofNullable(expectedClient));
        Optional<Client> actualOptionalUser = clientDaoMock.findById(CLIENT_ID);
        if (actualOptionalUser.isPresent()) {
            actual = actualOptionalUser.get();
        }
        assertThat(actual).isEqualTo(expectedClient);
    }

    @Test
    public void testFindByIdUser() throws DaoException{
        when(clientDaoMock.findByIdUser(USER_ID)).thenReturn(Optional.ofNullable(expectedClient));
        Optional<Client> actualOptionalUser = clientDaoMock.findByIdUser(USER_ID);
        if (actualOptionalUser.isPresent()) {
            actual = actualOptionalUser.get();
        }
        assertThat(actual).isEqualTo(expectedClient);
    }

    @Test
    public void testFindByEmail() throws DaoException{
        when(clientDaoMock.deleteByLogin(CLIENT_EMAIL))
                .thenReturn(EXPECTED_ROWS_UPDATED);
        boolean actual = clientDaoMock.deleteByLogin(CLIENT_EMAIL);
        assertThat(actual).isEqualTo(EXPECTED_ROWS_UPDATED);

    }

    @Test
    public void testUpdateClient() throws DaoException{
    }

    @Test
    public void testDeleteByLogin() throws DaoException{
    }

    @Test
    public void testUpdatePassword() throws DaoException{
    }

    @Test
    public void testDeleteById() throws DaoException{
    }

    @Test
    public void testInsertNewEntity() throws DaoException{
    }

    @Test
    public void testUpdateEmail() throws DaoException{
    }

    @Test
    public void testUpdateCashInBankAccount() throws DaoException{
    }

    @Test
    public void testWithdrawalCashFromBankAccount() throws DaoException{
    }

    @Test
    public void testUpdatePassportNumber() throws DaoException{
    }
}