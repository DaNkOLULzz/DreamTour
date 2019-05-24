package com.softserve.academy.dreamtour.controller;

import com.softserve.academy.dreamtour.entity.Hotel;
import com.softserve.academy.dreamtour.service.implementations.HotelServiceImpl;
import com.softserve.academy.dreamtour.service.interfaces.IHotelService;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HotelPageServlet")
public class HotelPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        try {
            int idHotel = Integer.parseInt(req.getParameter("id"));
            IHotelService hotelService = new HotelServiceImpl();
            Hotel hotel = hotelService.get(idHotel);

            req.setAttribute("hotel", hotel);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

    }

}
