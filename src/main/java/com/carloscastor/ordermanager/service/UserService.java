package com.carloscastor.ordermanager.service;

import com.carloscastor.ordermanager.dto.UserDTO;
import com.carloscastor.ordermanager.entity.UserEntity;
import com.carloscastor.ordermanager.exception.OMBadRequestException;
import com.carloscastor.ordermanager.mapper.Mapper;
import com.carloscastor.ordermanager.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCRUDService<UserEntity, UserDTO, Integer, UserRepository> {
    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, Mapper<UserDTO, UserEntity> mapper) {
        super(userRepository, mapper);
    }

    @Override
    public UserDTO create(UserDTO dto) {
        getRepository().findByEmail(dto.getEmail()).ifPresent(u -> {
            LOGGER.error("Email already taken");
            throw new OMBadRequestException(("Email already taken"));
        });
        return super.create(dto);
    }
}
