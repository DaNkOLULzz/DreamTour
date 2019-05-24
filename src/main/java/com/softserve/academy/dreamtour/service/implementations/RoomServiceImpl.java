package com.softserve.academy.dreamtour.service.implementations;

import com.softserve.academy.dreamtour.dao.implementations.RoomDaoImpl;
import com.softserve.academy.dreamtour.dao.interfaces.IRoomDao;
import com.softserve.academy.dreamtour.entity.Room;
import com.softserve.academy.dreamtour.service.interfaces.IRoomService;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

public class RoomServiceImpl implements IRoomService {

    private IRoomDao roomDao;

    public RoomServiceImpl() throws SQLException, NamingException {
        roomDao = new RoomDaoImpl();
    }

    @Override
    public List<Room> getAll() throws SQLException, NamingException {
        return roomDao.getAll();
    }

    @Override
    public boolean add(Room room) throws SQLException, NamingException {
        return roomDao.add(room);
    }

    @Override
    public Room get(int id) throws SQLException, NamingException {
        return roomDao.get(id);
    }

    @Override
    public boolean update(Room room) throws SQLException, NamingException {
        return roomDao.update(room);
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        return roomDao.delete(id);
    }

    @Override
    public List<Room> getFreeRoomsInHotel(int idHotel) throws SQLException, NamingException {
        return roomDao.getFreeRoomsInHotel(idHotel);
    }
}
