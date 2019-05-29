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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            int personId = 0;
            try {
                personId = (Integer) session.getAttribute("userId");
            } catch (NullPointerException e) {
                req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
            }
            LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
            LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));
            int countryId = Integer.parseInt(req.getParameter("countryId"));
            int cityId = Integer.parseInt(req.getParameter("cityId"));
            int hotelId = Integer.parseInt(req.getParameter("hotelId"));
            IVisaService visaService = new VisaServiceImpl();
            Visa visa = visaService.hasVisa(personId, countryId, endDate);
            int visaId = visa.getIdVisa();
            if (visaId == 0) {
                visaId = visaService.getIdVisaByCountryByDate(personId, countryId, endDate);
            }
            int roomId = Integer.parseInt(req.getParameter("roomId"));
            Booking booking = new Booking(startDate, endDate, countryId, cityId,
                personId, hotelId, visaId, roomId);
            IBookingService bookingService = new BookingServiceImpl();
            System.out.println(booking.toString());
            bookingService.add(booking);
            req.getRequestDispatcher("pages/profile.jsp").forward(req, resp);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
