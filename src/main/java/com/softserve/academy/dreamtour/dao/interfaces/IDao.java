package com.softserve.academy.dreamtour.dao.interfaces;

import java.util.List;

public interface IDao<T> {

    List<T> getAll();
    
    boolean add(T t);         // C
    T get(int id);            // R
    boolean update(T t);      // U
    boolean delete(int id);   // D

}
