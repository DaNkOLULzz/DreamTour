package com.softserve.academy.dreamtour.dao.interfaces;

import com.softserve.academy.dreamtour.entity.Room;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

public interface IRoomDao extends IDao<Room> {
    List<Room> getFreeRoomsInHotel(int idHotel) throws SQLException, NamingException;
}
