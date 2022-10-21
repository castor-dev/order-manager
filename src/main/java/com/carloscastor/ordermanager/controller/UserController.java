package com.carloscastor.ordermanager.controller;

import com.carloscastor.ordermanager.dto.UserDTO;
import com.carloscastor.ordermanager.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody UserDTO user){
        userService.create(user);
    }
    public UserDTO retrieveUser(Integer userId){
        return null;
    }
    public void updateUser(Integer userId, UserDTO user){

    }
    public void deleteUser(Integer userId){

    }
}
