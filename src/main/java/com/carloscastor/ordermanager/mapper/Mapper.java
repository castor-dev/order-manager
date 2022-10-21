package com.carloscastor.ordermanager.mapper;

public interface Mapper<DTO, ENT> {

    DTO fromEntityToDTO(ENT entity);
    ENT fromDTOToEntity(DTO dto);
}
