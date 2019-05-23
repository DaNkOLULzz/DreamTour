package com.softserve.academy.dreamtour.service.interfaces;

import com.softserve.academy.dreamtour.entity.City;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;


public interface ICityService {

    List<City> getAll() throws SQLException, NamingException;

    boolean add(City city) throws SQLException, NamingException; // C

    City get(int id) throws SQLException, NamingException; // R

    boolean update(City city) throws SQLException, NamingException; // U

    boolean delete(int id) throws SQLException, NamingException; // D

    List<String> getCityNameByCountry(String countryName) throws SQLException, NamingException;
}
