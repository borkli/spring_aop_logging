package com.aop.app.service;

import com.aop.app.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource("classpath:application.yml")
public class UserServiceTest  {

    @Autowired
    private UserService userService;

    @Test
    void testCreateUser() {
        User user = new User()
            .setName("user")
            .setEmail("test@email.ru");
        user = userService.createUser(user);
        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.getId());
    }
}
