package com.example.finalproject.model.dao.impl;

import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.ClientDao;
import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class ButlerDaoImplTest {
    public static final long BUTLER_ID = 2;
    public static final byte NEW_RATING = 5;
    public static final String BUTLER_LOGIN ="bim@gmail.com";
    private static final boolean EXPECTED_ROWS_UPDATED = true;
    private ClientDao clientDao = new ClientDaoImpl();
    private Butler actual;


    @Mock
    private ButlerDaoImpl butlerDaoMock;
    private Butler expectedButler;
    private List<Butler> expectedButlers;
    private Butler firstButler;
    private Butler secondButler;
    private Butler toUpdate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        expectedButler = new Butler(13, "bim@gmail.com", "bimA12-3", UserRole.BUTLER, "Bim", "Browen", "445675544", 2, (byte) 4);
        firstButler = new Butler(13, "bim@gmail.com", "bimA12-3", UserRole.BUTLER, "Bim", "Browen", "445675544", 2, (byte) 4);
        secondButler = new Butler(15, "bimDoled@gmail.com", "bimA12-3", UserRole.BUTLER, "Bim", "Doled", "447896544", 5, (byte) 4);
        expectedButlers = List.of(firstButler, secondButler);
        toUpdate = new Butler(13, "bim@gmail.com", "bimA12-3", UserRole.BUTLER, "Bim", "Browen", "445675544", 2, (byte) 5);
    }


    @Test
    public void testFindAll() throws DaoException {
        when(butlerDaoMock.findAll()).thenReturn(expectedButlers);
        List<Butler> actual = butlerDaoMock.findAll();
        assertThat(actual).containsExactly(firstButler, secondButler);
    }

    @Test
    public void testFindById() throws DaoException {
        when(butlerDaoMock.findById(BUTLER_ID)).thenReturn(Optional.ofNullable(expectedButler));
        Optional<Butler> actualOptionalUser = butlerDaoMock.findById(BUTLER_ID);
        if (actualOptionalUser.isPresent()) {
            actual = actualOptionalUser.get();
        }
        assertThat(actual).isEqualTo(expectedButler);
    }

    @Test
    public void testDeleteById() throws DaoException {
        when(butlerDaoMock.deleteById(BUTLER_ID))
                .thenReturn(EXPECTED_ROWS_UPDATED);
        boolean actual = butlerDaoMock.deleteById(BUTLER_ID);
        assertThat(actual).isEqualTo(EXPECTED_ROWS_UPDATED);
    }

    @Test
    public void testInsertNewEntity() throws DaoException {
        when(butlerDaoMock.insertNewEntity(firstButler)).thenReturn(expectedButler);
        User actual = butlerDaoMock.insertNewEntity(firstButler);
        assertThat(actual).isEqualTo(expectedButler);
    }

    @Test
    public void testUpdateRatingById() throws DaoException {
        when(butlerDaoMock.updateRatingById(BUTLER_ID, NEW_RATING))
                .thenReturn(EXPECTED_ROWS_UPDATED);
        boolean actual = butlerDaoMock.updateRatingById(BUTLER_ID,NEW_RATING);
        assertThat(actual).isEqualTo(EXPECTED_ROWS_UPDATED);
    }

    @Test
    public void testFindByIdUser() throws DaoException {
    }

    @Test
    public void testDeleteByLogin() throws DaoException {
        when(butlerDaoMock.deleteByLogin(BUTLER_LOGIN))
                .thenReturn(EXPECTED_ROWS_UPDATED);
        boolean actual = butlerDaoMock.deleteByLogin(BUTLER_LOGIN);
        assertThat(actual).isEqualTo(EXPECTED_ROWS_UPDATED);
    }
}