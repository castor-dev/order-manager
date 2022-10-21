package com.carloscastor.ordermanager.mapper;

import com.carloscastor.ordermanager.dto.UserDTO;
import com.carloscastor.ordermanager.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<UserDTO, UserEntity> {
    @Override
    public UserDTO fromEntityToDTO(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    @Override
    public UserEntity fromDTOToEntity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}
