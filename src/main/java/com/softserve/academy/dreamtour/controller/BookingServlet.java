package com.softserve.academy.dreamtour.controller;

import com.softserve.academy.dreamtour.entity.Booking;
import com.softserve.academy.dreamtour.entity.Person;
import com.softserve.academy.dreamtour.entity.Visa;
import com.softserve.academy.dreamtour.service.implementations.BookingServiceImpl;
import com.softserve.academy.dreamtour.service.implementations.PersonServiceImpl;
import com.softserve.academy.dreamtour.service.implementations.VisaServiceImpl;
import com.softserve.academy.dreamtour.service.interfaces.IBookingService;
import com.softserve.academy.dreamtour.service.interfaces.IPersonService;
import com.softserve.academy.dreamtour.service.interfaces.IVisaService;
import com.softserve.academy.dreamtour.utils.DateUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            int personId = (Integer) session.getAttribute("userId");
            LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
            LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));
            int countryId = Integer.parseInt(req.getParameter("id_country"));
            int cityId = Integer.parseInt(req.getParameter("id_city"));
            int hotelId = Integer.parseInt(req.getParameter("id_hotel"));
            IVisaService visaService = new VisaServiceImpl();
            int visaId = visaService.hasVisa(personId, countryId, endDate).getIdVisa();
            int roomId = Integer.parseInt(req.getParameter("id_room"));
            Booking booking = new Booking(startDate, endDate, countryId, cityId,
                personId, hotelId, visaId, roomId);
            IBookingService bookingService = new BookingServiceImpl();
            bookingService.add(booking);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
