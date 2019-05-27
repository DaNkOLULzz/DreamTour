package com.softserve.academy.dreamtour.controller;

import com.softserve.academy.dreamtour.entity.Hotel;
import com.softserve.academy.dreamtour.service.implementations.HotelServiceImpl;
import com.softserve.academy.dreamtour.service.interfaces.IHotelService;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/HotelListServlet")
public class HotelListServlet extends HttpServlet {

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

        IHotelService hotelService = null;
        List<Hotel> hotels = null;
        int []countTourist=null;
        int [] averageStay=null;

        try {
            hotelService = new HotelServiceImpl();
            if (startDate.equals("") && endDate.equals("")) {
                hotels = hotelService.getAllHotelsByCityName(chosenCity);

            } else {
                hotels = hotelService.getAllAvailableHotelsInCity(startDate, endDate, chosenCity);
            }
            countTourist = new int[hotels.size()];
            averageStay = new int[hotels.size()];

            for (Hotel hotel : hotels) {
                int i=0;
                countTourist[i] = hotelService.countTourist(hotel.getHotelName());
                averageStay[i] = hotelService.averageStay(hotel.getHotelName());
                i++;
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        req.setAttribute("startDate", startDate);
        req.setAttribute("endDate", endDate);
        req.setAttribute("hotelList", hotels);
        req.setAttribute("countTourist",countTourist);
        req.setAttribute("averageStay", averageStay);
        req.getRequestDispatcher("pages/hotelList.jsp").forward(req, resp);
    }

}
