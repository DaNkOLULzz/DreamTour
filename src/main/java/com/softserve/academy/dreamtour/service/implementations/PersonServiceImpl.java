package com.softserve.academy.dreamtour.service.implementations;

import com.softserve.academy.dreamtour.dao.implementations.PersonDaoImpl;
import com.softserve.academy.dreamtour.dao.interfaces.IPersonDao;
import com.softserve.academy.dreamtour.entity.Person;
import com.softserve.academy.dreamtour.service.interfaces.IPersonService;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

public class PersonServiceImpl implements IPersonService {

    private IPersonDao personDao = new PersonDaoImpl();

    @Override
    public List<Person> getAll() throws SQLException, NamingException {

        return personDao.getAll();
    }

    @Override
    public boolean add(Person person) throws SQLException, NamingException {

        return personDao.add(person);
    }

    @Override
    public Person get(int id) throws SQLException, NamingException {

        return personDao.get(id);
    }

    @Override
    public boolean update(Person person) throws SQLException, NamingException {

        return personDao.update(person);
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {

        return personDao.delete(id);
    }
    
    public Person getPersonByCredentials(String username)
            throws SQLException, NamingException {
        
        return personDao.getPersonByCredentials(username);
    }

}
