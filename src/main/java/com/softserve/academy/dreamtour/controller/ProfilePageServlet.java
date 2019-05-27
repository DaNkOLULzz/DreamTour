package com.softserve.academy.dreamtour.controller;

import com.softserve.academy.dreamtour.entity.Person;
import com.softserve.academy.dreamtour.service.implementations.PersonServiceImpl;
import com.softserve.academy.dreamtour.service.interfaces.IPersonService;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/profile")
public class ProfilePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        IPersonService iPersonService = new PersonServiceImpl();

        try {

            String currentUsername = (String) session.getAttribute("user");
            Person person = iPersonService.getPersonByCredentials(currentUsername);

            req.setAttribute("person", person);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("pages/profile.jsp").forward(req, resp);
    }
}
