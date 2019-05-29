package com.softserve.academy.dreamtour.controller;

import com.softserve.academy.dreamtour.entity.Booking;
import com.softserve.academy.dreamtour.entity.Country;
import com.softserve.academy.dreamtour.entity.Person;
import com.softserve.academy.dreamtour.entity.Visa;
import com.softserve.academy.dreamtour.service.implementations.BookingServiceImpl;
import com.softserve.academy.dreamtour.service.implementations.CountryServiceImpl;
import com.softserve.academy.dreamtour.service.implementations.PersonServiceImpl;
import com.softserve.academy.dreamtour.service.implementations.VisaServiceImpl;
import com.softserve.academy.dreamtour.service.interfaces.IBookingService;
import com.softserve.academy.dreamtour.service.interfaces.ICountryService;
import com.softserve.academy.dreamtour.service.interfaces.IPersonService;
import com.softserve.academy.dreamtour.service.interfaces.IVisaService;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/profile")
public class ProfilePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        IVisaService visaService = new VisaServiceImpl();
        IPersonService personService = new PersonServiceImpl();

        try {
            IBookingService bookingService = new BookingServiceImpl();
            ICountryService countryService = new CountryServiceImpl();
            Integer userId = (Integer) session.getAttribute("userId");
            Person person = personService.get(userId);

            List<Visa> visaList = visaService.getAllVisaByPerson(userId);
            List<Country> countryList = new ArrayList<>();
            List<Booking> bookingList = bookingService.getAllByPerson(userId);

            for(Visa visa: visaList){

                Country country = countryService.get(visa.getIdCountry());
                countryList.add(country);
            }

            req.setAttribute("person", person);
            req.setAttribute("countryList", countryList);
            req.setAttribute("visaList", visaList);
            req.setAttribute("bookingList", bookingList);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("pages/profile.jsp").forward(req, resp);
    }
}
