package com.softserve.academy.dreamtour.service.implementations;

import com.softserve.academy.dreamtour.dao.implementations.VisaDaoImpl;
import com.softserve.academy.dreamtour.dao.interfaces.IVisaDao;
import com.softserve.academy.dreamtour.entity.Visa;
import com.softserve.academy.dreamtour.service.interfaces.IVisaService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.naming.NamingException;


public class VisaServiceImpl implements IVisaService {

    @Override
    public Visa hasVisa(int idPerson, int idCountry, LocalDate endDate) throws SQLException, NamingException {
        List<Visa> visaList = getAllVisaByPerson(idPerson);
        for (Visa visa : visaList) {
            if (visa.getIdCountry() == idCountry && visa.getIdPerson() == idPerson
                && visa.getEndDate().isAfter(endDate)) {
                return visa;
            }
        }
        Visa visa = new Visa(idPerson, idCountry, endDate);
        add(visa);
        return visa;
    }

    private IVisaDao visaDao = new VisaDaoImpl();

    @Override
    public List<Visa> getAll() throws SQLException, NamingException {

        return visaDao.getAll();
    }

    @Override
    public int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate)
        throws SQLException, NamingException {

        return visaDao.getIdVisaByCountryByDate(personId, countryId, endDate);
    }

    @Override
    public boolean add(Visa visa) throws SQLException, NamingException {

        return visaDao.add(visa);
    }

    @Override
    public Visa get(int id) throws SQLException, NamingException {

        return visaDao.get(id);
    }

    @Override
    public boolean update(Visa visa) throws SQLException, NamingException {

        return visaDao.update(visa);
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {

        return visaDao.delete(id);
    }

    @Override
    public List<Visa> getAllVisaByPerson(int idPerson) throws SQLException, NamingException {

        return visaDao.getAllVisaByPerson(idPerson);
    }

}
