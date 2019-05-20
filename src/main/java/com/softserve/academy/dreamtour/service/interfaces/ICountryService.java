package com.softserve.academy.dreamtour.service.interfaces;

import com.softserve.academy.dreamtour.entity.Country;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface ICountryService {

    List<Country> getAll() throws SQLException, NamingException;

    boolean add(Country country) throws SQLException, NamingException; // C

    Country get(int id) throws SQLException, NamingException; // R

    boolean update(Country country) throws SQLException, NamingException; // U

    boolean delete(int id) throws SQLException, NamingException; // D

    List<String> getCountryNameByPerson(int personId) throws SQLException;
}
