package com.softserve.academy.dreamtour.dao.interfaces;

import com.softserve.academy.dreamtour.entity.City;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface ICityDao extends  IDao<City>{

    List<String> getCityByCountry(String countryName) throws SQLException, NamingException;
}
