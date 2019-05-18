package com.softserve.academy.dreamtour.dao.implementations;

import com.softserve.academy.dreamtour.config.DBConnection;
import com.softserve.academy.dreamtour.dao.interfaces.IPersonDao;
import com.softserve.academy.dreamtour.entity.Person;
import com.softserve.academy.dreamtour.enums.PersonType;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

public class PersonDaoImpl implements IPersonDao {

    public List<Person> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean add(Person person) throws SQLException, NamingException {

        String sql = "INSERT INTO person (username, pass, first_name, last_name, person_type) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, person.getUsername());
        ps.setString(2, person.getPassword());
        ps.setString(3, person.getFirstName());
        ps.setString(4, person.getLastName());
        ps.setString(5, "user");
        
        int rows = ps.executeUpdate();
        
        return rows > 0;
    }

    public Person get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean update(Person person) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}
