package com.softserve.academy.dreamtour.controller;

import com.softserve.academy.dreamtour.entity.Room;
import com.softserve.academy.dreamtour.service.implementations.RoomServiceImpl;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/RoomListServlet")
public class RoomListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int chosenHotel = Integer.parseInt(req.getParameter("chosenHotel")); //Make sure it will be INTEGER!!!
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        RoomServiceImpl roomService = new RoomServiceImpl();
        List<Room> rooms = null;
        try {
            rooms = roomService.getFreeRoomsInHotel(startDate, endDate, chosenHotel);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        req.setAttribute("hotelList", rooms);
        req.getRequestDispatcher("pages/roomList.jsp").forward(req, resp);

    }
}
