package com.softserve.academy.dreamtour.controller;

import com.softserve.academy.dreamtour.entity.Hotel;
import com.softserve.academy.dreamtour.service.implementations.CityServiceImpl;
import com.softserve.academy.dreamtour.service.implementations.HotelServiceImpl;
import com.softserve.academy.dreamtour.service.interfaces.ICityService;
import com.softserve.academy.dreamtour.service.interfaces.IHotelService;
import com.softserve.academy.dreamtour.utils.DateUtils;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HotelList")
public class HotelList extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println(req.getParameter("chosenCountry"));
        System.out.println(req.getParameter("chosenCity"));
        System.out.println(req.getParameter("startDate"));
        System.out.println(req.getParameter("endDate"));


        String chosenCity = req.getParameter("chosenCity");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        LocalDate sDate = DateUtils.dateParser(startDate);
        LocalDate eDate = DateUtils.dateParser(endDate);


        IHotelService hotelService = new HotelServiceImpl();
        List<Hotel> hotels = null;


        try {
            if (startDate.equals("") && endDate.equals("")) {
                hotels = hotelService.getAllHotelsByCityName(chosenCity);
            } else {
                //here will be method checking for available hotels by date
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        req.setAttribute("hotelList", hotels);
        req.getRequestDispatcher("pages/hotelList.jsp").forward(req, resp);
    }

}
