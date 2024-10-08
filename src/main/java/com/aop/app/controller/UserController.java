package com.aop.app.controller;

import com.aop.app.dto.UserDto;
import com.aop.app.model.User;
import com.aop.app.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    public UserDto createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
