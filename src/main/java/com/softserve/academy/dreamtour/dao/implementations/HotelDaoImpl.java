package com.softserve.academy.dreamtour.dao.implementations;

import com.softserve.academy.dreamtour.config.DBConnection;
import com.softserve.academy.dreamtour.dao.interfaces.IHotelDao;
import com.softserve.academy.dreamtour.entity.City;
import com.softserve.academy.dreamtour.entity.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import java.util.List;

public class HotelDaoImpl implements IHotelDao {

    @Override
    public List<Hotel> getAll() throws SQLException, NamingException {
        String query = "SELECT * FROM hotel;";
        ArrayList<Hotel> hotelList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Hotel hotel = new Hotel();
            hotel.setIdHotel(set.getInt("id"));
            hotel.setHotelName(set.getString("hotel_name"));
            hotel.setHotelDescription(set.getString("hotel_description"));
            hotel.setImageUrl(set.getString("image_url"));
            hotel.setStars(set.getInt("stars"));
            int cityId = set.getInt("city_id");
            City city = new CityDaoImpl.get(cityId);
            hotel.setCity(city);
            hotelList.add(hotel);
        }
        statement.close();

        return hotelList;
    }

    @Override
    public boolean add(Hotel hotel) throws SQLException, NamingException {
        String query = "INSERT INTO hotel (hotel_name, hotel_description, image_url, stars, "
            + "id_city) VALUES(?, ?, ?, ?, ?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        String hotelName = hotel.getHotelName();
        String hotelDescription = hotel.getHotelDescription();
        String imageUrl = hotel.getImageUrl();
        int stars = hotel.getStars();
        City city = hotel.getCity();
        statement.setString(1, hotelName);
        statement.setString(2, hotelDescription);
        statement.setString(3, imageUrl);
        statement.setInt(4, stars);
        statement.setInt(5, city.getCityId());
        boolean added = statement.execute();
        statement.close();

        return added;
    }

    @Override
    public Hotel get(int id) throws SQLException, NamingException {
        String query = "SELECT * FROM hotel WHERE id = ?;";
        Hotel hotel = new Hotel();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            hotel.setIdHotel(set.getInt("id"));
            hotel.setHotelName(set.getString("hotel_name"));
            hotel.setHotelDescription(set.getString("hotel_description"));
            hotel.setImageUrl(set.getString("image_url"));
            hotel.setStars(set.getInt("stars"));
            int cityId = set.getInt("city_id");
            City city = new CityDaoImpl.get(cityId);
            hotel.setCity(city);
        }
        statement.close();

        return hotel;
    }

    @Override
    public boolean update(Hotel hotel) throws SQLException, NamingException {
        String query = "UPDATE city SET hotel_name=?, hotel_description=? image_url=? stars=? "
            + "id_city=? WHERE id=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        int hotelId = hotel.getIdHotel();
        String hotelName = hotel.getHotelName();
        String hotelDescription = hotel.getHotelDescription();
        String imageUrl = hotel.getImageUrl();
        int stars = hotel.getStars();
        City city = hotel.getCity();
        statement.setString(1, hotelName);
        statement.setString(2, hotelDescription);
        statement.setString(3, imageUrl);
        statement.setInt(4, stars);
        statement.setInt(5, city.getCityId());
        statement.setInt(6, hotelId);
        boolean updated = statement.execute();
        statement.close();

        return updated;
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        String query = "DELETE FROM hotel WHERE id=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        boolean deleted = statement.execute();
        statement.close();

        return deleted;
    }
}
