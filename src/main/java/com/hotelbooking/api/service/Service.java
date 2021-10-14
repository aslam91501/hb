package com.hotelbooking.api.service;

import java.util.List;

public interface Service<T> {
    void create(T T);
    
    T get(Long id);
    List<T> getAll();
    
    void update(T T);
    
    void delete(Long id);
}
