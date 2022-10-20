package com.carloscastor.ordermanager.service;

public interface GenericService<T, ID>{

    void create(T dto);
    T findByID(ID id);
    void update(ID id, T dto);
    void delete(ID id);
}
