package com.aop.app.service;

import com.aop.app.model.User;
import com.aop.app.repository.UserRepository;
import org.springframework.core.annotation.Order;

@Order
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

}
