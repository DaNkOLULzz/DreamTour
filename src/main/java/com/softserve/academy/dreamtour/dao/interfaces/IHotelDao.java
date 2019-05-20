package com.softserve.academy.dreamtour.dao.interfaces;

import com.softserve.academy.dreamtour.entity.Hotel;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface IHotelDao extends IDao<Hotel> {

    int[] hotelStatistics(String hotelName) throws SQLException, NamingException;

}
