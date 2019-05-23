package com.softserve.academy.dreamtour.dao.interfaces;

import com.softserve.academy.dreamtour.entity.Country;

import java.sql.SQLException;
import java.util.List;

public interface ICountryDao extends IDao<Country> {

    List<String> getCountryNameByPerson(int personId) throws SQLException;

    List<String> getCountryName() throws SQLException;
}
