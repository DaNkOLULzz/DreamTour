package com.softserve.academy.dreamtour.controller;

import com.softserve.academy.dreamtour.service.implementations.CountryServiceImpl;
import com.softserve.academy.dreamtour.service.interfaces.ICountryService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCountriesServlet")
public class GetCountriesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        try {
            
            ICountryService countryService = new CountryServiceImpl();
            List<String> countryList = countryService.getAllNames();
            
            req.setAttribute("countries", countryList);
        } catch (SQLException | NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
