package com.carloscastor.ordermanager.service;

import com.carloscastor.ordermanager.dto.ItemDTO;
import com.carloscastor.ordermanager.dto.UserDTO;
import com.carloscastor.ordermanager.entity.ItemEntity;
import com.carloscastor.ordermanager.entity.UserEntity;
import com.carloscastor.ordermanager.mapper.Mapper;
import com.carloscastor.ordermanager.mapper.UserMapper;
import com.carloscastor.ordermanager.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCRUDService<UserEntity, UserDTO, Integer, UserRepository> {
    public UserService(UserRepository userRepository, Mapper<UserDTO, UserEntity> mapper) {
        super(userRepository, mapper);
    }

}
