package com.aop.app.service;

import com.aop.app.model.Order;
import com.aop.app.model.User;
import com.aop.app.repository.OrderRepository;

import java.util.Objects;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order order, User user) {
        if (order.getUser() == null) {
            order.setUser(user);
        } else if (!Objects.equals(user.getId(), order.getUser().getId())) {
            throw new RuntimeException("invalid order");
        }
        orderRepository.save(order);
    }
}
