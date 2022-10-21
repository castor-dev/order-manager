package com.carloscastor.ordermanager.service.impl;

import com.carloscastor.ordermanager.dto.UserDTO;
import com.carloscastor.ordermanager.entity.UserEntity;
import com.carloscastor.ordermanager.repository.UserRepository;
import com.carloscastor.ordermanager.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserDTO dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(dto.getName());
        userEntity.setEmail(dto.getEmail());
        UserEntity savedEntity = userRepository.save(userEntity);
    }

    @Override
    public UserDTO findByID(Integer integer) {
        return null;
    }

    @Override
    public void update(Integer integer, UserDTO dto) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
