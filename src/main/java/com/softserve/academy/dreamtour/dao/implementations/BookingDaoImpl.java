package com.softserve.academy.dreamtour.dao.implementations;

import com.softserve.academy.dreamtour.config.DBConnection;
import com.softserve.academy.dreamtour.dao.interfaces.IBookingDao;
import com.softserve.academy.dreamtour.entity.Booking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

public class BookingDaoImpl implements IBookingDao {

    private Connection connection;

    public BookingDaoImpl() throws SQLException, NamingException {
        connection = DBConnection.getConnection();
    }

    @Override
    public List<Booking> getAll() throws SQLException, NamingException {
        String query = "SELECT * FROM booking;";
        ArrayList<Booking> bookingList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Booking booking = new Booking();
            booking.setIdBooking(set.getInt("id"));
            booking.setStartDate(set.getDate("startDate").toLocalDate());
            booking.setEndDate(set.getDate("endDate").toLocalDate());
            booking.setIdCountry(set.getInt("id_country"));
            booking.setIdCity(set.getInt("id_city"));
            booking.setIdPerson(set.getInt("id_tourist"));
            booking.setIdHotel(set.getInt("id_hotel"));
            booking.setIdVisa(set.getInt("id_visa"));
            booking.setIdRoom(set.getInt("id_room"));
            bookingList.add(booking);
        }
        statement.close();

        return bookingList;
    }

    @Override
    public boolean add(Booking booking) throws SQLException, NamingException {
        String query = "INSERT INTO booking (startDate, endDate, id_country, id_city, "
                + "id_tourist, id_hotel, id_visa, id_room) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        LocalDate startDate = booking.getStartDate();
        LocalDate endDate = booking.getEndDate();
        int idCountry = booking.getIdCountry();
        int idCity = booking.getIdCity();
        int idTourist = booking.getIdPerson();
        int idHotel = booking.getIdHotel();
        int idVisa = booking.getIdVisa();
        int idRoom = booking.getIdRoom();
        statement.setDate(1, Date.valueOf(startDate));
        statement.setDate(2, Date.valueOf(endDate));
        statement.setInt(3, idCountry);
        statement.setInt(4, idCity);
        statement.setInt(5, idTourist);
        statement.setInt(6, idHotel);
        statement.setInt(7, idVisa);
        statement.setInt(8, idRoom);
        boolean isAdded = statement.execute();
        statement.close();

        return isAdded;
    }

    @Override
    public Booking get(int id) throws SQLException, NamingException {
        String query = "SELECT * FROM booking WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        Booking booking = new Booking();
        while (set.next()) {
            booking.setIdBooking(set.getInt("id"));
            booking.setStartDate(set.getDate("startDate").toLocalDate());
            booking.setEndDate(set.getDate("endDate").toLocalDate());
            booking.setIdCountry(set.getInt("id_country"));
            booking.setIdCity(set.getInt("id_city"));
            booking.setIdPerson(set.getInt("id_tourist"));
            booking.setIdHotel(set.getInt("id_hotel"));
            booking.setIdVisa(set.getInt("id_visa"));
            booking.setIdRoom(set.getInt("id_room"));
        }
        statement.close();

        return booking;
    }

    @Override
    public boolean update(Booking booking) throws SQLException, NamingException {
        String query = "UPDATE booking SET startDate = ?, endDate = ?, id_country = ?, id_city = ?,"
                + "id_tourist = ?, id_hotel = ?, id_visa = ?, id_room = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        int idBooking = booking.getIdBooking();
        LocalDate startDate = booking.getStartDate();
        LocalDate endDate = booking.getEndDate();
        int idCountry = booking.getIdCountry();
        int idCity = booking.getIdCity();
        int idTourist = booking.getIdPerson();
        int idHotel = booking.getIdHotel();
        int idVisa = booking.getIdVisa();
        int idRoom = booking.getIdRoom();
        statement.setDate(1, Date.valueOf(startDate));
        statement.setDate(2, Date.valueOf(endDate));
        statement.setInt(3, idCountry);
        statement.setInt(4, idCity);
        statement.setInt(5, idTourist);
        statement.setInt(6, idHotel);
        statement.setInt(7, idVisa);
        statement.setInt(8, idRoom);
        statement.setInt(9, idBooking);
        boolean isUpdated = statement.execute();
        statement.close();

        return isUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        String query = "DELETE FROM booking WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        boolean isDeleted = statement.execute();
        statement.close();

        return isDeleted;
    }

    @Override
    public List<Booking> getAllByPerson(int idPerson) throws SQLException, NamingException {

        ArrayList<Booking> bookingList = new ArrayList<>();

        String sql = "SELECT * FROM booking WHERE id_tourist=?;";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, idPerson);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Booking booking = new Booking();
            booking.setIdBooking(rs.getInt("id"));
            booking.setStartDate(rs.getDate("startDate").toLocalDate());
            booking.setEndDate(rs.getDate("endDate").toLocalDate());
            booking.setIdCountry(rs.getInt("id_country"));
            booking.setIdCity(rs.getInt("id_city"));
            booking.setIdPerson(rs.getInt("id_tourist"));
            booking.setIdHotel(rs.getInt("id_hotel"));
            booking.setIdVisa(rs.getInt("id_visa"));
            booking.setIdRoom(rs.getInt("id_room"));
            bookingList.add(booking);
        }
        ps.close();

        return bookingList;
    }
}
