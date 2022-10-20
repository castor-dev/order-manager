package com.carloscastor.ordermanager.controller;

import com.carloscastor.ordermanager.dto.UserDTO;

public interface UserController {

    void createUser(UserDTO user);
    UserDTO retrieveUser(Integer userId);
    void updateUser(Integer userId, UserDTO user);
    void deleteUser(Integer userId);
}
