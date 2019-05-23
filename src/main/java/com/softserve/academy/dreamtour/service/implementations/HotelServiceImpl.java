package com.softserve.academy.dreamtour.service.implementations;

import com.softserve.academy.dreamtour.dao.implementations.CityDaoImpl;
import com.softserve.academy.dreamtour.dao.implementations.HotelDaoImpl;
import com.softserve.academy.dreamtour.dao.interfaces.ICityDao;
import com.softserve.academy.dreamtour.dao.interfaces.IHotelDao;
import com.softserve.academy.dreamtour.entity.City;
import com.softserve.academy.dreamtour.entity.Hotel;
import com.softserve.academy.dreamtour.service.interfaces.IHotelService;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

public class HotelServiceImpl implements IHotelService {

    private IHotelDao hotelDao = null;
    private ICityDao cityDao = null;

    public HotelServiceImpl() throws SQLException, NamingException {
        this.hotelDao = new HotelDaoImpl();
        this.cityDao = new CityDaoImpl();
    }

    @Override
    public List<Hotel> getAll() throws SQLException, NamingException {
        return hotelDao.getAll();
    }

    @Override
    public boolean add(Hotel hotel) throws SQLException, NamingException {
        return hotelDao.add(hotel);
    }

    @Override
    public Hotel get(int id) throws SQLException, NamingException {
        return hotelDao.get(id);
    }

    @Override
    public boolean update(Hotel hotel) throws SQLException, NamingException {
        return hotelDao.update(hotel);
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        return hotelDao.delete(id);
    }

    @Override
    public List<Hotel> getAllHotelsByCityName(String cityName) throws SQLException, NamingException {
        return hotelDao.getAllHotelsByCityName(cityName);
    }

    @Override
    public int[] hotelStatistics(String hotelName) throws SQLException, NamingException {
        return hotelDao.hotelStatistics(hotelName);
    }

    @Override
    public List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName) throws SQLException, NamingException {

        City city = cityDao.getCityByName(cityName);
        int cityId = city.getCityId();
        return hotelDao.getAllAvailableHotelsInCity(startDate,endDate,cityId);
    }
}
