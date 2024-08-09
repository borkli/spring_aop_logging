package com.aop.app.service;

import com.aop.app.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource("classpath:application.yml")
@ActiveProfiles("test")
public class UserServiceTest extends CommonTest {

    private final String methodName = "UserService.createUser(..)";

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("Successful create user")
    void testCreateUser() {
        User user = userService.createUser(
            new User()
                .setName("user")
                .setEmail("test@email.ru")
        );

        assertNotNull(user);
        assertNotNull(user.getId());
        assertLogMessage("Entering " + methodName + " with args");
        assertLogMessage("Exiting " + methodName + " with result");
    }

    @Test
    @DisplayName("Create duplicate user")
    void testCreateDuplicateUser() {
        userService.createUser(
            new User()
                .setName("user")
                .setEmail("testDuplicate@email.ru")
        );
        userService.createUser(
            new User()
                .setName("user")
                .setEmail("testDuplicate@email.ru")
        );

//        assertNotNull(user);
//        assertNotNull(user.getId());
    }
}
