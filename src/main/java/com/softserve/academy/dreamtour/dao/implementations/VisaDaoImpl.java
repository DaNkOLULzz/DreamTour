package com.softserve.academy.dreamtour.dao.implementations;

import com.softserve.academy.dreamtour.config.DBConnection;
import com.softserve.academy.dreamtour.dao.interfaces.IVisaDao;
import com.softserve.academy.dreamtour.entity.Visa;

import javax.naming.NamingException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisaDaoImpl implements IVisaDao {

    public List<Visa> getAll() throws SQLException, NamingException {

        ArrayList<Visa> visaList = new ArrayList<>();

        String sql = "SELECT * FROM visa";

        Statement statement = DBConnection.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {

            Visa visa = new Visa();
            visa.setIdVisa(rs.getInt("id"));
            visa.setEndDate(rs.getDate("endDate").toLocalDate());
            visa.setIdPerson(rs.getInt("id_tourist"));
            visa.setIdCountry(rs.getInt("id_country"));
            visaList.add(visa);
        }
        statement.close();

        return visaList;
    }

    @Override
    public int getVisaCountByCountryForPerson(
        String countryName, int idPerson) throws SQLException, NamingException {

        String sql = "SELECT COUNT(id) AS count FROM visa WHERE id_country = "
            + "(SELECT id FROM country WHERE country_name = ?) AND id_tourist = ?;";

        PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
        statement.setString(1, countryName);
        statement.setInt(2, idPerson);
        ResultSet rs = statement.executeQuery(sql);
        int visaCount = rs.getInt("count");
        statement.close();

        return visaCount;
    }

    public boolean add(Visa visa) throws SQLException, NamingException {

        String sql = "INSERT INTO Visa (endDate, id_tourist, id_country) "
            + "VALUES (?, ?, ?)";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setDate(1, Date.valueOf(visa.getEndDate()));
        ps.setInt(2, visa.getIdPerson());
        ps.setInt(3, visa.getIdCountry());

        boolean isAdded = ps.executeUpdate() > 0;
        ps.close();

        return isAdded;
    }

    public Visa get(int id) throws SQLException, NamingException {

        Visa visa = new Visa();

        String sql = "SELECT * FROM visa WHERE visa.id = ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            visa.setIdVisa(rs.getInt("id"));
            visa.setEndDate(rs.getDate("endDate").toLocalDate());
            visa.setIdPerson(rs.getInt("id_tourist"));
            visa.setIdCountry(rs.getInt("id_country"));
        }
        ps.close();

        return visa;
    }

    public boolean update(Visa visa) throws SQLException, NamingException {

        String sql = "UPDATE visa SET id_country=? WHERE id=?";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, visa.getIdCountry());
        ps.setInt(2, visa.getIdVisa());

        boolean isUpdated = ps.execute();
        ps.close();

        return isUpdated;
    }

    public boolean delete(int id) throws SQLException, NamingException {

        String sql = "DELETE FROM visa WHERE id=?";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, id);

        boolean isDeleted = ps.execute();
        ps.close();

        return isDeleted;
    }

    @Override
    public List<Visa> getAllVisaByPerson(int idPerson) throws SQLException, NamingException {

        ArrayList<Visa> visaList = new ArrayList<>();

        String sql = "SELECT id, endDate, id_country FROM visa WHERE id_tourist=? ;";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, idPerson);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Visa visa = new Visa();
            visa.setIdVisa(rs.getInt("id"));
            visa.setEndDate(rs.getDate("endDate").toLocalDate());
            visa.setIdPerson(idPerson);
            visa.setIdCountry(rs.getInt("id_country"));
            visaList.add(visa);
        }
        ps.close();

        return visaList;

    }

    @Override
    public int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate)
        throws SQLException, NamingException {

        String sql = "SELECT id FROM visa WHERE id_tourist=? AND id_country=? AND endDate=?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, personId);
        ps.setInt(2, countryId);
        ps.setDate(3, Date.valueOf(endDate));
        ResultSet rs = ps.executeQuery();

        int visaId = 0;
        while (rs.next()) {
            visaId = rs.getInt("id");
        }

        ps.close();

        return visaId;
    }
}
