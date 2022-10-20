package com.carloscastor.ordermanager.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {

    @GetMapping("/")
    public String helloUser(@Param("name") String name){
        return Strings.isBlank(name) ? "Hello User" : "Hello " + name;
    }
}
