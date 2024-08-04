package com.aop.app.service;

import com.aop.app.model.User;
import com.aop.app.repository.UserRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
