package com.softserve.academy.dreamtour.dao.implementations;

import com.softserve.academy.dreamtour.config.DBConnection;
import com.softserve.academy.dreamtour.dao.interfaces.ICountryDao;
import com.softserve.academy.dreamtour.entity.Country;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl implements ICountryDao {

    private Connection con;

    public CountryDaoImpl() throws SQLException, NamingException {
        con = DBConnection.getConnection();

    }

    @Override
    public List<Country> getAll() throws SQLException {

        ArrayList<Country> countryList = new ArrayList<>();
        String query = "SELECT * FROM country";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Country country = new Country();
            country.setCountryId(rs.getInt("id"));
            country.setCountryName(rs.getString("country_name"));
            countryList.add(country);
        }
        statement.close();
        return countryList;
    }

    @Override
    public boolean add(Country country) throws SQLException {
        String query = "INSERT INTO country (country_name) VALUES (?)";
        boolean added = false;
        PreparedStatement statement = con.prepareStatement(query);
        String countryName = country.getCountryName();
        statement.setString(1, countryName);
        added = statement.execute();
        statement.close();

        return added;
    }

    @Override
    public Country get(int id) throws SQLException {
        String query = "SELECT country_name FROM country WHERE country.id = ?";
        Country country = new Country();
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            country.setCountryId(set.getInt("id"));
            country.setCountryName(set.getString("country_name"));
        }
        statement.close();

        return country;
    }

    @Override
    public boolean update(Country country) throws SQLException {
        boolean updated = false;
        String query = "UPDATE country SET country_name=? WHERE id=?";
        PreparedStatement statement = con.prepareStatement(query);
        String countryName = country.getCountryName();
        int countryId = country.getCountryId();
        statement.setString(1, countryName);
        statement.setInt(2, countryId);
        updated = statement.execute();
        statement.close();
        return updated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean deleted = false;
        String query = "DELETE FROM country WHERE id=?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, id);
        deleted = statement.execute();
        statement.close();
        return deleted;

    }
}
