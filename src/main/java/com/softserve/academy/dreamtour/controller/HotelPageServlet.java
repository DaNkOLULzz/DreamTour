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
            IHotelService hotelService = new HotelServiceImpl();
            Hotel hotel = hotelService.get(idHotel);
            req.setAttribute("hotel", hotel);
            req.getRequestDispatcher("pages/hotelPage.jsp").forward(req, resp);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
