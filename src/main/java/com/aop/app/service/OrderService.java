package com.aop.app.service;

import com.aop.app.dto.OrderDto;
import com.aop.app.exception.ApplicationException;
import com.aop.app.model.Order;
import com.aop.app.model.User;
import com.aop.app.repository.OrderRepository;
import com.aop.app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public OrderDto createOrder(Order order, long userId) {
        try {
            User user = userRepository.getReferenceById(userId);
            order.setUser(user);
        } catch (Exception ex) {
            throw new ApplicationException("User not found " + userId, ex);
        }
        return new OrderDto(orderRepository.save(order), userId);
    }
}
