package com.carloscastor.ordermanager.service;

import com.carloscastor.ordermanager.dto.BaseDTO;
import com.carloscastor.ordermanager.entity.BaseEntity;
import com.carloscastor.ordermanager.exception.OMBadRequestException;
import com.carloscastor.ordermanager.exception.OMNotFoundException;
import com.carloscastor.ordermanager.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public abstract class AbstractCRUDService<ENT extends BaseEntity, DTO extends BaseDTO, ID, REPO extends JpaRepository<ENT, ID>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCRUDService.class);
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
        dto.setId(null);
        ENT entity = mapper.fromDTOToEntity(dto);
        ENT savedEntity = repository.save(entity);
        return mapper.fromEntityToDTO(savedEntity);
    }

    public DTO findByID(ID id) {
        ENT entity = getEntity(id);
        return mapper.fromEntityToDTO(entity);
    }

    public List<DTO> findAll(){
        List<ENT> all = repository.findAll();
        return all.stream().map(e -> getMapper().fromEntityToDTO(e)).collect(Collectors.toList());
    }


    public DTO update(ID id, DTO dto) {
        ENT entity = getEntity(id);
        if (!id.equals(entity.getId())) {
            LOGGER.error(String.format("[%s] Source id (%s) different from Target id (s)",this.getClass().getSimpleName(), entity.getId(), id));
            throw new OMBadRequestException("Entity ID can't be changed");
        }
        ENT ent = mapper.fromDTOToEntity(dto);
        return mapper.fromEntityToDTO(repository.save(ent));
    }

    public void delete(ID id) {
        ENT entity = getEntity(id);
        repository.delete(entity);
    }

    private ENT getEntity(ID id) {
        ENT entity = repository.findById(id).orElse(null);
        if (Objects.isNull(entity)) {
            LOGGER.error(String.format("[%s] Entity with id %s not found", this.getClass().getSimpleName(), id));
            throw new OMNotFoundException("Not Found");
        }
        return entity;
    }

}
