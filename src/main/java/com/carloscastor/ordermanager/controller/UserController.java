package com.carloscastor.ordermanager.controller;

import com.carloscastor.ordermanager.dto.UserDTO;
import com.carloscastor.ordermanager.service.EmailService;
import com.carloscastor.ordermanager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;
    private EmailService emailService;

    public UserController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserDTO user){
        return userService.create(user);
    }
    @GetMapping("/{user-id}")
    public UserDTO retrieveUser(@PathVariable("user-id") Integer userId){
        return userService.findByID(userId);
    }
    @PutMapping("/{user-id}")
    public UserDTO updateUser(@PathVariable("user-id") Integer userId, @RequestBody UserDTO user){
        return userService.update(userId,user);
    }
    @DeleteMapping("/{user-id}")
    public void deleteUser(@PathVariable("user-id") Integer userId){
        userService.delete(userId);
    }
}
