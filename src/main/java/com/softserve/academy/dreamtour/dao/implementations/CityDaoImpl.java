package com.softserve.academy.dreamtour.dao.implementations;

import com.softserve.academy.dreamtour.config.DBConnection;
import com.softserve.academy.dreamtour.dao.interfaces.ICityDao;
import com.softserve.academy.dreamtour.entity.City;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements ICityDao {

    private Connection con;

    public CityDaoImpl() throws SQLException, NamingException {
        con = DBConnection.getConnection();
    }

    @Override
    public List<City> getAll() throws SQLException, NamingException {
        ArrayList<City> cityList = new ArrayList<>();
        String query = "SELECT * FROM city";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            City city = new City();
            city.setCityId(rs.getInt("id"));
            city.setCityName(rs.getString("city_name"));
            city.setCountryId(rs.getInt("id_country"));
            cityList.add(city);
        }
        statement.close();
        return cityList;
    }

    @Override
    public boolean add(City city) throws SQLException {
        String query = "INSERT INTO city (city_name, id_country) VALUES (?,?)";
        boolean added = false;
        PreparedStatement statement = con.prepareStatement(query);
        String cityName = city.getCityName();
        int countryId = city.getCountryId();
        statement.setString(1, cityName);
        statement.setInt(2, countryId);
        added = statement.execute();
        statement.close();

        return added;
    }

    @Override
    public City get(int id) throws SQLException, NamingException {
        String query = "SELECT * FROM city WHERE city.id = ?";
        City city = new City();
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            city.setCityId(set.getInt("id"));
            city.setCityName(set.getString("country_name"));
            city.setCountryId(set.getInt("id_country"));
        }
        statement.close();
        return city;
    }

    @Override
    public City getCityByName(String cityName) throws SQLException, NamingException {
        String query = "SELECT * FROM city WHERE city_name = ?";
        City city = new City();
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, cityName);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            city.setCityId(set.getInt("id"));
            city.setCityName(set.getString("country_name"));
            city.setCountryId(set.getInt("id_country"));
        }
        statement.close();
        return city;
    }

    @Override
    public boolean update(City city) throws SQLException {
        boolean updated = false;
        String query = "UPDATE city SET city_name=?, id_country=? WHERE id=?";
        PreparedStatement statement = con.prepareStatement(query);
        String cityName = city.getCityName();
        int cityId = city.getCityId();
        int countryId = city.getCountryId();
        statement.setString(1, cityName);
        statement.setInt(2, countryId);
        statement.setInt(3, cityId);
        updated = statement.execute();
        statement.close();
        return updated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean deleted = false;
        String query = "DELETE FROM city WHERE id=?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, id);
        deleted = statement.execute();
        statement.close();
        return deleted;
    }

    @Override
    public List<String> getAllCityNames() throws SQLException, NamingException {
        ArrayList<String> cityList = new ArrayList<>();
        String query = "SELECT city_name FROM city";
        Statement statement = con.createStatement();
        ResultSet set = statement.executeQuery(query);
        while (set.next()) {
            String cityName = set.getString("city_name");
            cityList.add(cityName);
        }
        return cityList;
    }

    @Override
    public List<String> getCityNameByCountry(String countryName) throws SQLException {
        ArrayList<String> cityList = new ArrayList<>();
        String query = "SELECT city_name FROM city, country WHERE country.country_name=? AND city.id_country=country.id";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, countryName);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            String cityName = set.getString("city_name");
            cityList.add(cityName);
        }
        statement.close();
        return cityList;
    }
}
