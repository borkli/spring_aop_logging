package com.aop.app.service;

import com.aop.app.dto.OrderDto;
import com.aop.app.dto.UserDto;
import com.aop.app.model.Order;
import com.aop.app.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
class OrderServiceTest extends CommonTest {

    private final String methodName = "OrderService.createOrder(..)";

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("Successful create order")
    void testCreateOrder() {
        UserDto user = userService.createUser(
            new User()
                .setName("user")
                .setEmail("testOrder@email.ru")
        );
        OrderDto order = orderService.createOrder(
            new Order().setDetails("Order"), user.getId()
        );
        assertNotNull(order);
        assertNotNull(order.getId());
        assertLogMessage("Entering " + methodName + " with args");
        assertLogMessage("Exiting " + methodName + " with result");
    }
}