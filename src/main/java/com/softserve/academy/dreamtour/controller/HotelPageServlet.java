package com.softserve.academy.dreamtour.controller;

import com.softserve.academy.dreamtour.entity.City;
import com.softserve.academy.dreamtour.entity.Hotel;
import com.softserve.academy.dreamtour.entity.Room;
import com.softserve.academy.dreamtour.enums.RoomType;
import com.softserve.academy.dreamtour.service.implementations.CityServiceImpl;
import com.softserve.academy.dreamtour.service.implementations.HotelServiceImpl;
import com.softserve.academy.dreamtour.service.implementations.RoomServiceImpl;
import com.softserve.academy.dreamtour.service.interfaces.ICityService;
import com.softserve.academy.dreamtour.service.interfaces.IHotelService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hotel")
public class HotelPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {


        System.out.println(req.getParameter("idHotel"));
        System.out.println(req.getParameter("startDate"));
        System.out.println(req.getParameter("endDate"));


        try {
            int idHotel = Integer.parseInt(req.getParameter("idHotel"));
            String startDate = req.getParameter("startDate");
            String endDate = req.getParameter("endDate");

            req.setAttribute("startDate", startDate);
            req.setAttribute("endDate", endDate);

            String cityName = req.getParameter("city");

            System.out.println("KEK" + cityName);

            ICityService cityService = new CityServiceImpl();
            City city = cityService.getCityByName(cityName);

            req.setAttribute("countryId", city.getCountryId());
            req.setAttribute("cityId", city.getCityId());

            RoomServiceImpl roomService = new RoomServiceImpl();
            List<Room> rooms = roomService.getFreeRoomsInHotel(startDate, endDate, idHotel);

            int countOfStandardRooms = 0;
            int countOfLuxeRooms = 0;
            for (Room room : rooms) {
                if (room.getRoomType() == RoomType.STANDARD) {
                    countOfStandardRooms++;
                    req.setAttribute("roomStandard", room);
                } else {
                    countOfLuxeRooms++;
                    req.setAttribute("roomLuxe", room);
                }
            }
            if (countOfStandardRooms == 0) {
                req.setAttribute("roomStandard", null);
            }
            if (countOfLuxeRooms == 0) {
                req.setAttribute("roomLuxe", null);
            }
            req.setAttribute("standardCount", countOfStandardRooms);
            req.setAttribute("luxeCount", countOfLuxeRooms);
            IHotelService hotelService = new HotelServiceImpl();
            Hotel hotel = hotelService.get(idHotel);
            req.setAttribute("hotel", hotel);

            req.getRequestDispatcher("pages/hotelPage.jsp").forward(req, resp);

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
