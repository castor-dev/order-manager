package com.carloscastor.ordermanager.controller.impl;

import com.carloscastor.ordermanager.controller.UserController;
import com.carloscastor.ordermanager.dto.UserDTO;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController("/users")
public class UserControllerImpl implements UserController {

    @GetMapping("/")
    public String helloUser(@Param("name") String name){
        return Strings.isBlank(name) ? "Hello User" : "Hello " + name;
    }


    @PostMapping
    public void createUser(UserDTO user) {

    }

    @GetMapping("/{userId}")
    @Override
    public UserDTO retrieveUser(@PathVariable("userId") Integer userId) {
        return null;
    }

    @PutMapping("/{userId}")
    @Override
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody UserDTO user) {

    }

    @Override
    public void deleteUser(@PathVariable("userId") Integer userId) {

    }
}
