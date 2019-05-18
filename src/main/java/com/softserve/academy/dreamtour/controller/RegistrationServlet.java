package com.softserve.academy.dreamtour.controller;

import com.softserve.academy.dreamtour.dao.implementations.PersonDaoImpl;
import com.softserve.academy.dreamtour.dao.interfaces.IPersonDao;
import com.softserve.academy.dreamtour.entity.Person;
import com.softserve.academy.dreamtour.enums.PersonType;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("pages/registration.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Person person = new Person(username, password, firstName,
                lastName, PersonType.GUEST);
        
        IPersonDao personDao = new PersonDaoImpl();

        try {
            personDao.add(person);
        } catch (SQLException | NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        response.sendRedirect("/main");
    }

}
