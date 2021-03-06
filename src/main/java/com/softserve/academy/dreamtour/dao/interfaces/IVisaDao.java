package com.softserve.academy.dreamtour.dao.interfaces;

import com.softserve.academy.dreamtour.entity.Visa;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.naming.NamingException;

public interface IVisaDao extends IDao<Visa> {

    int getVisaCountByCountryForPerson(String countryName, int idPerson)
        throws SQLException, NamingException;

    List<Visa> getAllVisaByPerson(int idPerson) throws SQLException, NamingException;

    int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate)
        throws SQLException, NamingException;

}
