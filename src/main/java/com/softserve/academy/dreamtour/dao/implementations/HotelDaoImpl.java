package com.softserve.academy.dreamtour.dao.implementations;

import com.softserve.academy.dreamtour.config.DBConnection;
import com.softserve.academy.dreamtour.dao.interfaces.IHotelDao;
import com.softserve.academy.dreamtour.entity.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

public class HotelDaoImpl implements IHotelDao {

    private Connection connection;

    public HotelDaoImpl() throws SQLException, NamingException {
        connection = DBConnection.getConnection();
    }

    @Override
    public List<Hotel> getAll() throws SQLException, NamingException {
        String query = "SELECT * FROM hotel;";
        ArrayList<Hotel> hotelList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Hotel hotel = new Hotel();
            hotel.setIdHotel(set.getInt("id"));
            hotel.setHotelName(set.getString("hotel_name"));
            hotel.setHotelDescription(set.getString("hotel_description"));
            hotel.setImageUrl(set.getString("image_url"));
            hotel.setStars(set.getInt("stars"));
            hotel.setIdCity(set.getInt("id_city"));
            hotelList.add(hotel);
        }
        statement.close();

        return hotelList;
    }

    @Override
    public List<Hotel> getAllHotelsByCityName(
        String cityName) throws SQLException {
        String query = "SELECT id, hotel_name, hotel_description, image_url, stars FROM hotel "
            + "WHERE id_city = (SELECT id FROM city WHERE city_name = ?);";
        ArrayList<Hotel> hotelList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cityName);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Hotel hotel = new Hotel();
            hotel.setIdHotel(set.getInt("id"));
            hotel.setHotelName(set.getString("hotel_name"));
            hotel.setHotelDescription(set.getString("hotel_description"));
            hotel.setImageUrl(set.getString("image_url"));
            hotel.setStars(set.getInt("stars"));
            hotelList.add(hotel);
        }
        statement.close();

        return hotelList;
    }

    @Override
    public boolean add(Hotel hotel) throws SQLException, NamingException {
        String query = "INSERT INTO hotel (hotel_name, hotel_description, image_url, stars, "
            + "id_city) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        String hotelName = hotel.getHotelName();
        String hotelDescription = hotel.getHotelDescription();
        String imageUrl = hotel.getImageUrl();
        int stars = hotel.getStars();
        int idCity = hotel.getIdCity();
        statement.setString(1, hotelName);
        statement.setString(2, hotelDescription);
        statement.setString(3, imageUrl);
        statement.setInt(4, stars);
        statement.setInt(5, idCity);
        boolean isAdded = statement.execute();
        statement.close();

        return isAdded;
    }

    @Override
    public Hotel get(int id) throws SQLException, NamingException {
        String query = "SELECT * FROM hotel WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        Hotel hotel = new Hotel();
        while (set.next()) {
            hotel.setIdHotel(set.getInt("id"));
            hotel.setHotelName(set.getString("hotel_name"));
            hotel.setHotelDescription(set.getString("hotel_description"));
            hotel.setImageUrl(set.getString("image_url"));
            hotel.setStars(set.getInt("stars"));
            hotel.setIdCity(set.getInt("id_city"));
        }
        statement.close();

        return hotel;
    }



    @Override
    public boolean update(Hotel hotel) throws SQLException, NamingException {
        String query = "UPDATE hotel SET hotel_name = ?, hotel_description = ?, image_url = ?, "
            + "stars = ?, id_city = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        int idHotel = hotel.getIdHotel();
        String hotelName = hotel.getHotelName();
        String hotelDescription = hotel.getHotelDescription();
        String imageUrl = hotel.getImageUrl();
        int stars = hotel.getStars();
        int idCity = hotel.getIdCity();
        statement.setString(1, hotelName);
        statement.setString(2, hotelDescription);
        statement.setString(3, imageUrl);
        statement.setInt(4, stars);
        statement.setInt(5, idCity);
        statement.setInt(6, idHotel);
        boolean isUpdated = statement.execute();
        statement.close();

        return isUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        String query = "DELETE FROM hotel WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        boolean isDeleted = statement.execute();
        statement.close();

        return isDeleted;
    }


    @Override

    public List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, int cityId) throws SQLException, NamingException {
        String query = "select distinct hotel.id, hotel.hotel_name, hotel.hotel_description, hotel.image_url, hotel.stars, hotel.id_city from hotel join city\n" +
                "on hotel.id in(select id_hotel from room where id not in\n" +
                "(select id_room from booking where not\n" +
                "(startDate >? or endDate<?))) and hotel.id_city = ?";
        if (endDate.equals("")) {
            endDate = "date_add(\"" + startDate + "\", INTERVAL 7 DAY)";

        }
        ArrayList<Hotel> hotelList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, endDate);
        statement.setString(2, startDate);
        statement.setInt(3, cityId);

        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Hotel hotel = new Hotel();
            hotel.setIdHotel(set.getInt("id"));
            hotel.setHotelName(set.getString("hotel_name"));
            hotel.setHotelDescription(set.getString("hotel_description"));
            hotel.setImageUrl(set.getString("image_url"));
            hotel.setStars(set.getInt("stars"));
            hotel.setIdCity(set.getInt("id_city"));
            hotelList.add(hotel);
        }
        statement.close();

        return hotelList;
    }

    @Override
    public int countTourist(String hotelName) throws SQLException, NamingException {

        int statData = 0;
        String query = "select count(booking.id) "
            + "from booking where booking.id_hotel=(select hotel.id from hotel where hotel_name=?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, hotelName);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
             statData = set.getInt(1);
        }
        statement.close();
        return statData;
    }

    @Override
    public int averageStay(String hotelName) throws SQLException, NamingException {
        String query = "select avg(datediff(booking.endDate, booking.startDate)) "
                + "from booking where booking.id_hotel=(select hotel.id from hotel where hotel_name=?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, hotelName);
        ResultSet set = statement.executeQuery();
        int averageStay=0;
        while (set.next()) {
            averageStay = set.getInt(1);
        }
        statement.close();
        return averageStay;
    }
}
