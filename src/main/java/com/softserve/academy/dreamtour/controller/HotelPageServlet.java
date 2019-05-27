package com.softserve.academy.dreamtour.controller;

import com.softserve.academy.dreamtour.entity.Hotel;
import com.softserve.academy.dreamtour.entity.Room;
import com.softserve.academy.dreamtour.service.implementations.HotelServiceImpl;
import com.softserve.academy.dreamtour.service.implementations.RoomServiceImpl;
import com.softserve.academy.dreamtour.service.interfaces.IHotelService;

import java.io.IOException;
import java.sql.SQLException;
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
        try {
            int idHotel = Integer.parseInt(req.getParameter("id"));
            String startDate = req.getParameter("startDate");
            String endDate = req.getParameter("endDate");
            RoomServiceImpl roomService = new RoomServiceImpl();
            List<Room> rooms = roomService.getFreeRoomsInHotel(startDate, endDate, idHotel);
            req.setAttribute("roomList", rooms);
            IHotelService hotelService = new HotelServiceImpl();
            Hotel hotel = hotelService.get(idHotel);
            req.setAttribute("hotel", hotel);
            req.getRequestDispatcher("pages/hotelPage.jsp").forward(req, resp);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
