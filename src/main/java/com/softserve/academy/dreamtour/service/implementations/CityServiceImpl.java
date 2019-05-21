package com.softserve.academy.dreamtour.service.implementations;

import com.softserve.academy.dreamtour.dao.implementations.CityDaoImpl;
import com.softserve.academy.dreamtour.dao.interfaces.ICityDao;
import com.softserve.academy.dreamtour.entity.City;
import com.softserve.academy.dreamtour.service.interfaces.ICityService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class CityServiceImpl implements ICityService {

    private ICityDao dao;

    public CityServiceImpl() throws SQLException, NamingException {
        this.dao = new CityDaoImpl();
    }

    @Override
    public List<City> getAll() throws SQLException, NamingException {
        return dao.getAll();
    }

    @Override
    public boolean add(City city) throws SQLException, NamingException {
        return dao.add(city);
    }

    @Override
    public City get(int id) throws SQLException, NamingException {
        return dao.get(id);
    }

    @Override
    public boolean update(City city) throws SQLException, NamingException {
        return dao.update(city);
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        return dao.delete(id);
    }

    @Override
    public List<String> getCityNameByCountry(String countryName) throws SQLException, NamingException {
        return dao.getCityNameByCountry(countryName);
    }
}
