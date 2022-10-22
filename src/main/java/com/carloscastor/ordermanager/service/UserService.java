package com.carloscastor.ordermanager.service;

import com.carloscastor.ordermanager.dto.UserDTO;
import com.carloscastor.ordermanager.entity.UserEntity;
import com.carloscastor.ordermanager.exception.OMInvalidOperationException;
import com.carloscastor.ordermanager.mapper.Mapper;
import com.carloscastor.ordermanager.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCRUDService<UserEntity, UserDTO, Integer, UserRepository> {
    public UserService(UserRepository userRepository, Mapper<UserDTO, UserEntity> mapper) {
        super(userRepository, mapper);
    }

    @Override
    public UserDTO create(UserDTO dto) {
        getRepository().findByEmail(dto.getEmail()).ifPresent(u -> {
            throw new OMInvalidOperationException(String.format("Email %s already used. Please, select another one", u.getEmail()));
        });
        return super.create(dto);
    }
}
