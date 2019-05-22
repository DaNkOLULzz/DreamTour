package com.softserve.academy.dreamtour.service.interfaces;

import com.softserve.academy.dreamtour.entity.Hotel;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

public interface IHotelService {
    List<Hotel> getAll() throws SQLException, NamingException;

    boolean add(Hotel hotel) throws SQLException, NamingException; // C

    Hotel get(int id) throws SQLException, NamingException; // R

    boolean update(Hotel hotel) throws SQLException, NamingException; // U

    boolean delete(int id) throws SQLException, NamingException; // D

    List<Hotel> getAllHotelsByCityName(String cityName) throws SQLException, NamingException;

    int[] hotelStatistics(String hotelName) throws SQLException, NamingException;
}
