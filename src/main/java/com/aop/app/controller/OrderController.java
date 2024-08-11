package com.aop.app.controller;

import com.aop.app.dto.OrderDto;
import com.aop.app.model.Order;
import com.aop.app.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order/")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("create")
    public OrderDto createOrder(@RequestBody Order order,
                                @RequestParam long userId) {
        return orderService.createOrder(order, userId);
    }
}
