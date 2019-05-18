package com.softserve.academy.dreamtour.dao.interfaces;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

    List<T> getAll() throws SQLException;
    
    boolean add(T t) throws SQLException;         // C
    T get(int id) throws SQLException, NamingException;            // R
    boolean update(T t) throws SQLException;      // U
    boolean delete(int id) throws SQLException;   // D

}
