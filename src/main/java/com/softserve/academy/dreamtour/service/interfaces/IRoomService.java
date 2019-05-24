package com.softserve.academy.dreamtour.service.interfaces;

import com.softserve.academy.dreamtour.entity.Room;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;


public interface IRoomService {
    List<Room> getAll() throws SQLException, NamingException;

    boolean add(Room room) throws SQLException, NamingException; // C

    Room get(int id) throws SQLException, NamingException; // R

    boolean update(Room room) throws SQLException, NamingException; // U

    boolean delete(int id) throws SQLException, NamingException; // D

    List<Room> getFreeRoomsInHotel(String startDate, String endDate, int idHotel) throws SQLException, NamingException;
}
