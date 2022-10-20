package com.carloscastor.ordermanager.controller.impl;

import com.carloscastor.ordermanager.controller.UserController;
import com.carloscastor.ordermanager.dto.UserDTO;
import com.carloscastor.ordermanager.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController("/users")
public class UserControllerImpl implements UserController {


    private UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String helloUser(@Param("name") String name){
        return Strings.isBlank(name) ? "Hello User" : "Hello " + name;
    }


    @PostMapping
    @Override
    public void create(@RequestBody UserDTO user) {
        userService.create(user);
    }

    @GetMapping("/{userId}")
    @Override
    public UserDTO retrieve(@PathVariable("userId") Integer userId) {
        return userService.findByID(userId);
    }

    @PutMapping("/{userId}")
    @Override
    public void update(@PathVariable("userId") Integer userId, @RequestBody UserDTO user) {
    userService.update(userId, user);
    }

    @Override
    public void delete(@PathVariable("userId") Integer userId) {
    userService.delete(userId);
    }
}
