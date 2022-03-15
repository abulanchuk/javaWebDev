package com.example.finalproject.model.dao.impl;

import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.UserDao;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

public class UserDaoImplTest {
    public static final long USER_ID = 17;
    private static final boolean EXPECTED_ROWS_UPDATED = true;
    private static final String LOGIN_TO_UPDATE = "johnpost";
    private static final String PASSWORD_TO_UPDATE = "Qwe123-0";
    private static final String SURNAME = "Poster";


    UserDao userDao = new UserDaoImpl();

    @Mock
    private UserDaoImpl userDaoMock;
    private User expectedUser;
    private User actual;
    private List<User> expectedUsers;
    private User firstUser;
    private User secondUser;
    private User toUpdate;
    private User expectedUpdated;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        expectedUser = new User(17, "jackposter", "-288712101-1153257-1203183-118-511346-7-88-1-10-105-7251-40-62-321183656124-8784-52-68",
                UserRole.CLIENT, "Jack", "Poster", "441112233");
        firstUser = new User(17, "jackposter", "-288712101-1153257-1203183-118-511346-7-88-1-10-105-7251-40-62-321183656124-8784-52-68",
                UserRole.CLIENT, "Jack", "Poster", "441112233");
        secondUser = new User(18, "joeafler", "-288712101-1153257-1203183-118-511346-7-88-1-10-105-7251-40-62-321183656124-8784-52-68",
                UserRole.CLIENT, "Joe", "Poster", "298904560");
        toUpdate = new User(17, "johnpost", "-288712101-1153257-1203183-118-511346-7-88-1-10-105-7251-40-62-321183656124-8784-52-68",
                UserRole.CLIENT, "John", "Post", "445678090");
        expectedUpdated = toUpdate;
        expectedUsers = List.of(firstUser, secondUser);
    }

    @Test
    public void testFindAll() throws DaoException {
        when(userDaoMock.findAll()).thenReturn(expectedUsers);
        List<User> actual = userDaoMock.findAll();
        assertThat(actual).containsExactly(firstUser, secondUser);
    }

    @Test
    public void testFindById() throws DaoException {
        when(userDaoMock.findById(USER_ID)).thenReturn(Optional.ofNullable(expectedUser));
        Optional<User> actualOptionalUser = userDaoMock.findById(USER_ID);
        if (actualOptionalUser.isPresent()) {
            actual = actualOptionalUser.get();
        }
        assertThat(actual).isEqualTo(expectedUser);
    }

    @Test
    public void testFindAllUsersByRole() throws DaoException {
        when(userDaoMock.findAllUsersByRole(UserRole.CLIENT)).thenReturn(expectedUsers);
        List<User> actual = userDaoMock.findAllUsersByRole(UserRole.CLIENT);
        assertThat(actual).containsExactly(firstUser, secondUser);
    }

    @Test
    public void testFindAllUsersWithSuchSurname() throws DaoException {
        when(userDaoMock.findAllUsersWithSuchSurname(SURNAME)).thenReturn(expectedUsers);
        List<User> actual = userDaoMock.findAllUsersWithSuchSurname(SURNAME);
        assertThat(actual).containsExactly(firstUser, secondUser);
    }

    @Test
    public void testInsertNewEntity() throws DaoException {
        when(userDaoMock.insertNewEntity(firstUser)).thenReturn(expectedUser);
        User actual = userDaoMock.insertNewEntity(firstUser);
        assertThat(actual).isEqualTo(expectedUser);
    }

    @Test
    public void testUpdateLogin() throws DaoException {
        when(userDaoMock.updateLogin(expectedUser.getLogin(), LOGIN_TO_UPDATE, USER_ID))
                .thenReturn(EXPECTED_ROWS_UPDATED);
        boolean actual = userDaoMock.updateLogin(expectedUser.getLogin(), LOGIN_TO_UPDATE, USER_ID);
        assertThat(actual).isEqualTo(EXPECTED_ROWS_UPDATED);
    }

    @Test
    public void testUpdateSurname() throws DaoException {
        when(userDaoMock.updateSurname(expectedUser.getIdUser(),expectedUser.getSurname()))
                .thenReturn(EXPECTED_ROWS_UPDATED);
        boolean actual = userDaoMock.updateSurname(expectedUser.getIdUser(),expectedUser.getSurname());
        assertThat(actual).isEqualTo(EXPECTED_ROWS_UPDATED);
    }

    @Test
    public void testUpdatePasswordByLogin() throws DaoException{
        when(userDaoMock.updatePasswordByLogin(expectedUser.getLogin(), expectedUser.getPassword(), PASSWORD_TO_UPDATE))
                .thenReturn(EXPECTED_ROWS_UPDATED);
        boolean actual = userDaoMock.updatePasswordByLogin(expectedUser.getLogin(), expectedUser.getPassword(), PASSWORD_TO_UPDATE);
        assertThat(actual).isEqualTo(EXPECTED_ROWS_UPDATED);
    }
}