package com.softserve.academy.dreamtour.service.implementations;

import com.softserve.academy.dreamtour.dao.implementations.CountryDaoImpl;
import com.softserve.academy.dreamtour.dao.interfaces.ICountryDao;
import com.softserve.academy.dreamtour.entity.Country;
import com.softserve.academy.dreamtour.service.interfaces.ICountryService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class CountryServiceImpl implements ICountryService {

    private ICountryDao dao;

    public CountryServiceImpl() throws SQLException, NamingException {
        this.dao = new CountryDaoImpl();
    }

    @Override
    public List<Country> getAll() throws SQLException, NamingException {
        return dao.getAll();
    }

    @Override
    public boolean add(Country country) throws SQLException, NamingException {
        return dao.add(country);
    }

    @Override
    public Country get(int id) throws SQLException, NamingException {
        return dao.get(id);
    }

    @Override
    public boolean update(Country country) throws SQLException, NamingException {
        return dao.update(country);
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        return dao.delete(id);
    }

    @Override
    public List<String> getCountryNameByPerson(int personId) throws SQLException {
        return dao.getCountryNameByPerson(personId);
    }
}
