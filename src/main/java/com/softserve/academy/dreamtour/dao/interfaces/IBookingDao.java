package com.softserve.academy.dreamtour.dao.interfaces;

import com.softserve.academy.dreamtour.entity.Booking;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface IBookingDao extends IDao<Booking> {

    List<Booking> getAllByPerson(int idPerson) throws SQLException, NamingException;
}
