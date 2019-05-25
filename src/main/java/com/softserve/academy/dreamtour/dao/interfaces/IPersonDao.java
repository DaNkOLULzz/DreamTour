package com.softserve.academy.dreamtour.dao.interfaces;

import com.softserve.academy.dreamtour.entity.Person;

import java.sql.SQLException;
import javax.naming.NamingException;

public interface IPersonDao extends IDao<Person> {

    Person getPersonByCredentials(String username) throws SQLException, NamingException;
}
