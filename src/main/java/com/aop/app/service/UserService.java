package com.aop.app.service;

import com.aop.app.dto.UserDto;
import com.aop.app.model.User;
import com.aop.app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(User user) {
        return new UserDto(userRepository.saveAndFlush(user));
    }
}
