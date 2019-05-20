package com.softserve.academy.dreamtour.service.interfaces;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.softserve.academy.dreamtour.entity.Visa;

public interface IVisaService {

    List<Visa> getAll() throws SQLException, NamingException;

    boolean add(Visa visa) throws SQLException, NamingException; // C

    Visa get(int id) throws SQLException, NamingException; // R

    boolean update(Visa visa) throws SQLException, NamingException; // U

    boolean delete(int id) throws SQLException, NamingException; // D

    List<Visa> getAllVisaByPerson(int idPerson) throws SQLException, NamingException;
}
