package com.softserve.academy.dreamtour.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.academy.dreamtour.entity.Person;
import com.softserve.academy.dreamtour.enums.PersonType;
import com.softserve.academy.dreamtour.service.implementations.PersonServiceImpl;
import com.softserve.academy.dreamtour.service.interfaces.IPersonService;
import com.softserve.academy.dreamtour.utils.HashPasswordUtil;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("pages/registration.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String passwordToHash = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        try {

            String securePassword = HashPasswordUtil.hashPassword(passwordToHash);
            IPersonService personService = new PersonServiceImpl();
            Person person = personService.getPersonByCredentials(username);

            if (person.getUsername() == null) {

                person = new Person(username, securePassword, firstName, lastName, PersonType.USER);
                personService.add(person);
                response.sendRedirect("/");
            } else {
                response.sendError(403, "User with this username already exists");
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

    }

}
