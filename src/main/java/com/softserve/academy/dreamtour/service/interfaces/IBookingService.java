package com.softserve.academy.dreamtour.service.interfaces;

import com.softserve.academy.dreamtour.entity.Booking;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;


public interface IBookingService {
    List<Booking> getAll() throws SQLException, NamingException;

    boolean add(Booking booking) throws SQLException, NamingException; // C

    Booking get(int id) throws SQLException, NamingException; // R

    boolean update(Booking booking) throws SQLException, NamingException; // U

    boolean delete(int id) throws SQLException, NamingException; // D
}
