package com.softserve.academy.dreamtour.entity;

import java.util.Objects;

public class Booking {
    private Long idBooking;
    private Country country;
    private City city;
    private Person person;
    private Hotel hotel;
    private Visa visa;
    private Room room;

    public Booking() {
    }

    public Booking(Long idBooking, Country country, City city, Person person,
                   Hotel hotel, Visa visa, Room room) {
        this.idBooking = idBooking;
        this.country = country;
        this.city = city;
        this.person = person;
        this.hotel = hotel;
        this.visa = visa;
        this.room = room;
    }

    public Long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Long idBooking) {
        this.idBooking = idBooking;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
        return idBooking.equals(booking.idBooking)
            && country.equals(booking.country)
            && city.equals(booking.city)
            && person.equals(booking.person)
            && hotel.equals(booking.hotel)
            && Objects.equals(visa, booking.visa)
            && room.equals(booking.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking, country, city, person, hotel, visa, room);
    }

    @Override
    public String toString() {
        return "Booking{"
            + "idBooking=" + idBooking
            + ", country=" + country
            + ", city=" + city
            + ", person=" + person
            + ", hotel=" + hotel
            + ", visa=" + visa
            + ", room=" + room
            + '}';
    }
}
