package com.aop.app.controller;

import com.aop.app.model.Order;
import com.aop.app.model.User;
import com.aop.app.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order/")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("create")
    public Order createOrder(@RequestBody Order order,
                             @RequestBody User user) {
        return orderService.createOrder(order, user);
    }
}
