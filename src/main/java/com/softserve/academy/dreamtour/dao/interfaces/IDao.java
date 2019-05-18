package com.softserve.academy.dreamtour.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

public interface IDao<T> {

    List<T> getAll() throws SQLException, NamingException;

    boolean add(T t) throws SQLException, NamingException; // C

    T get(int id) throws SQLException, NamingException; // R

    boolean update(T t) throws SQLException, NamingException; // U

    boolean delete(int id) throws SQLException, NamingException; // D

}
