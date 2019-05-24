package com.softserve.academy.dreamtour.service.implementations;

import com.softserve.academy.dreamtour.dao.implementations.BookingDaoImpl;
import com.softserve.academy.dreamtour.dao.interfaces.IBookingDao;
import com.softserve.academy.dreamtour.entity.Booking;
import com.softserve.academy.dreamtour.service.interfaces.IBookingService;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

public class BookingServiceImpl implements IBookingService {

    private IBookingDao bookingDao;

    public BookingServiceImpl() throws SQLException, NamingException{
        bookingDao = new BookingDaoImpl();
    }

    @Override
    public List<Booking> getAll() throws SQLException, NamingException {
        return bookingDao.getAll();
    }

    @Override
    public boolean add(Booking booking) throws SQLException, NamingException {
        return bookingDao.add(booking);
    }

    @Override
    public Booking get(int id) throws SQLException, NamingException {
        return bookingDao.get(id);
    }

    @Override
    public boolean update(Booking booking) throws SQLException, NamingException {
        return bookingDao.update(booking);
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        return bookingDao.delete(id);
    }
}
