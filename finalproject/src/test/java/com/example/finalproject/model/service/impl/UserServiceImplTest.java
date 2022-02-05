package com.example.finalproject.model.service.impl;

import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;
import com.example.finalproject.model.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;


public class UserServiceImplTest {
    private static final UserService service = UserServiceImpl.getInstance();
    private static HttpServletRequest request;
    private static HttpSession session;

    @BeforeTest
    public static void init() {
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
    }


    @Test
    public void testFindUserByPhoneNumber() throws ServiceException {
        User userExpected = new User(16, "annakozlova", "-6233-121-1630-72123-8536111-1622-5528-47-337252-124-10-4-1140-4367-69207894-83-663", UserRole.CLIENT, "Anna", "Kozlova", "447972273");
        Optional<User> userFromMethod = service.findUserByPhoneNumber("447972273");
        User user = userFromMethod.isPresent() ? userFromMethod.get() : new User();

        Assert.assertEquals(userExpected, user);
    }

    @Test
    public void testFindUserByLoginAndPassword() throws ServiceException {
        Optional<User> user = service.findUserByLogin(anyString());
        Assert.assertNotNull(user);
    }
}