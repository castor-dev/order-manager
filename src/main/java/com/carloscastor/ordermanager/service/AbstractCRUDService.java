package com.carloscastor.ordermanager.service;

import com.carloscastor.ordermanager.dto.BaseDTO;
import com.carloscastor.ordermanager.entity.BaseEntity;
import com.carloscastor.ordermanager.exception.OMInvalidOperationException;
import com.carloscastor.ordermanager.exception.OMNotFoundException;
import com.carloscastor.ordermanager.mapper.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractCRUDService<ENT extends BaseEntity, DTO extends BaseDTO, ID, REPO extends JpaRepository<ENT, ID>> {

    private REPO repository;
    private Mapper<DTO, ENT> mapper;

    public AbstractCRUDService(REPO repository, Mapper<DTO, ENT> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public REPO getRepository() {
        return repository;
    }

    public Mapper<DTO, ENT> getMapper() {
        return mapper;
    }

    public DTO create(DTO dto) {
        ENT entity = mapper.fromDTOToEntity(dto);
        ENT savedEntity = repository.save(entity);
        return mapper.fromEntityToDTO(savedEntity);
    }

    public DTO findByID(ID id){
        ENT entity = repository.findById(id).orElseThrow(() -> new OMNotFoundException("Not Found"));
        return mapper.fromEntityToDTO(entity);
    }


    public DTO update(ID id, DTO dto) {
        ENT entity = repository.findById(id).orElseThrow(() -> new OMNotFoundException("Not Found"));
        if(!id.equals(entity.getId())){
            throw new OMInvalidOperationException("Entity ID can't be changed");
        }
        ENT ent = mapper.fromDTOToEntity(dto);
        return mapper.fromEntityToDTO(repository.save(ent));
    }

    public void delete(ID id) {
        ENT entity = repository.findById(id).orElseThrow(() -> new OMNotFoundException("Not Found"));
        repository.delete(entity);
    }

}
