package com.carloscastor.ordermanager.controller;

public interface GenericController<T, ID> {

    void create(T dto);
    T retrieve(ID id);
    void update(ID id, T dto);
    void delete(ID id);
}
