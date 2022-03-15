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
    private final User firstUserByRole = new User(17, "jackposter", "-288712101-1153257-1203183-118-511346-7-88-1-10-105-7251-40-62-321183656124-8784-52-68",
            UserRole.CLIENT, "Jack", "Poster", "441112233");
    private final User secondUserByRole = new User(18, "joeafler", "-288712101-1153257-1203183-118-511346-7-88-1-10-105-7251-40-62-321183656124-8784-52-68",
            UserRole.CLIENT, "Joe", "Afler", "298904560");

    UserDao userDao = new UserDaoImpl();
    
    @Mock
    private UserDaoImpl userDaoMock;
    private User expectedUser;
    private User actual;
    private List<User> expectedUsersByRole;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        expectedUser = new User(17, "jackposter", "-288712101-1153257-1203183-118-511346-7-88-1-10-105-7251-40-62-321183656124-8784-52-68",
                UserRole.CLIENT, "Jack", "Poster", "441112233");

        expectedUsersByRole = List.of(firstUserByRole, secondUserByRole);
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
        when(userDaoMock.findAllUsersByRole(UserRole.CLIENT)).thenReturn(expectedUsersByRole);
        List<User> actual = userDaoMock.findAllUsersByRole(UserRole.CLIENT);
        assertThat(actual).containsExactly(firstUserByRole, secondUserByRole);
    }

}