package com.softserve.academy.dreamtour.dao.implementations;

import com.softserve.academy.dreamtour.config.DBConnection;
import com.softserve.academy.dreamtour.dao.interfaces.IPersonDao;
import com.softserve.academy.dreamtour.entity.City;
import com.softserve.academy.dreamtour.entity.Person;
import com.softserve.academy.dreamtour.enums.PersonType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

public class PersonDaoImpl implements IPersonDao {

    public List<Person> getAll() throws SQLException, NamingException {

        ArrayList<Person> personList = new ArrayList<>();

        String sql = "SELECT * FROM person";

        Statement statement = DBConnection.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {

            Person person = new Person();
            person.setIdPerson(rs.getInt("id"));
            person.setUsername(rs.getString("username"));
            person.setPassword(rs.getString("pass"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setPersonType(PersonType.valueOf(rs.getString("person_type")));

            personList.add(person);
        }
        statement.close();

        return personList;
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

        boolean isAdded = ps.executeUpdate() > 0;
        ps.close();

        return isAdded;
    }

    public Person get(int id) throws SQLException, NamingException {

        Person person = new Person();

        String sql = "SELECT * FROM person WHERE person.id = ?";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            person.setIdPerson(rs.getInt("id"));
            person.setUsername(rs.getString("username"));
            person.setPassword(rs.getString("pass"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setPersonType(PersonType.USER);
        }
        ps.close();

        return person;
    }

    public boolean update(Person person) throws SQLException, NamingException {

        String sql = "UPDATE person SET first_name=?, last_name=? WHERE id=?";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, person.getFirstName());
        ps.setString(2, person.getLastName());
        ps.setInt(3, person.getIdPerson());

        boolean isUpdated = ps.execute();
        ps.close();

        return isUpdated;
    }

    public boolean delete(int id) throws SQLException, NamingException {

        String sql = "DELETE FROM person WHERE id=?";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, id);

        boolean isDeleted = ps.execute();
        ps.close();

        return isDeleted;
    }

    @Override
    public Person getPersonByCredentials(String username)
            throws SQLException, NamingException {

        Person person = new Person();

        String sql = "SELECT * FROM person WHERE person.username = ?";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            person.setIdPerson(rs.getInt("id"));
            person.setUsername(rs.getString("username"));
            person.setPassword(rs.getString("pass"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setPersonType(PersonType.USER);
        }
        ps.close();

        return person;
    }

}
