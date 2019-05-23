package com.softserve.academy.dreamtour.controller;

import com.softserve.academy.dreamtour.service.implementations.CityServiceImpl;
import com.softserve.academy.dreamtour.service.interfaces.ICityService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetCitiesServlet")
public class GetCitiesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        String chosenCountry = request.getParameter("country");

        try {

            ICityService cityService = new CityServiceImpl();
            List<String> cityList = null;

            if (chosenCountry.equals("allCountries") == false) {

                cityList = (ArrayList<String>) cityService.getCityNameByCountry(chosenCountry);
                System.out.println(chosenCountry);
                System.out.println(cityList.toString());
            }
            
            StringBuilder cityNames = new StringBuilder();

            for (String cityName : cityList) {
                cityNames.append(cityName + ",");
            }

            response.getWriter().write(cityNames.substring(0, cityNames.length() - 1));

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

    }

}
