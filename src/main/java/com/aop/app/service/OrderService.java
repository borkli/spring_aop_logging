package com.aop.app.service;

import com.aop.app.exception.ApplicationException;
import com.aop.app.model.Order;
import com.aop.app.model.User;
import com.aop.app.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order, User user) {
        if (order.getUser() == null) {
            order.setUser(user);
        } else if (!Objects.equals(user.getId(), order.getUser().getId())) {
            throw new ApplicationException("Invalid order");
        }
        return orderRepository.save(order);
    }
}
