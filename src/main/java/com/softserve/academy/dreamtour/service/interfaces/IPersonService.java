package com.softserve.academy.dreamtour.service.interfaces;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.softserve.academy.dreamtour.entity.Person;

public interface IPersonService {

    List<Person> getAll() throws SQLException, NamingException;

    boolean add(Person person) throws SQLException, NamingException; // C

    Person get(int id) throws SQLException, NamingException; // R

    boolean update(Person person) throws SQLException, NamingException; // U

    boolean delete(int id) throws SQLException, NamingException; // D
}
