package com.softserve.academy.dreamtour.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Booking {

    private int idBooking;
    private LocalDate startDate;
    private LocalDate endDate;
    private int idCountry;
    private int idCity;
    private int idPerson;
    private int idHotel;
    private int idVisa;
    private int IdRoom;

    public Booking() {
    }

    public Booking(LocalDate startDate, LocalDate endDate, int idCountry, int idCity,
                   int idPerson, int idHotel, int idVisa, int idRoom) {
        this.idBooking = idBooking;
        this.startDate = startDate;
        this.endDate = endDate;
        this.idCountry = idCountry;
        this.idCity = idCity;
        this.idPerson = idPerson;
        this.idHotel = idHotel;
        this.idVisa = idVisa;
        IdRoom = idRoom;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getIdVisa() {
        return idVisa;
    }

    public void setIdVisa(int idVisa) {
        this.idVisa = idVisa;
    }

    public int getIdRoom() {
        return IdRoom;
    }

    public void setIdRoom(int idRoom) {
        IdRoom = idRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return idBooking == booking.idBooking
            && idCountry == booking.idCountry
            && idCity == booking.idCity
            && idPerson == booking.idPerson
            && idHotel == booking.idHotel
            && idVisa == booking.idVisa
            && IdRoom == booking.IdRoom
            && Objects.equals(startDate, booking.startDate)
            && Objects.equals(endDate, booking.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking, startDate, endDate, idCountry, idCity, idPerson,
            idHotel, idVisa, IdRoom);
    }

    @Override
    public String toString() {
        return "Booking{"
            + "idBooking=" + idBooking
            + ", startDate=" + startDate
            + ", endDate=" + endDate
            + ", idCountry=" + idCountry
            + ", idCity=" + idCity
            + ", idPerson=" + idPerson
            + ", idHotel=" + idHotel
            + ", idVisa=" + idVisa
            + ", IdRoom=" + IdRoom
            + '}';
    }
}
