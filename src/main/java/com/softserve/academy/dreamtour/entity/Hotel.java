package com.softserve.academy.dreamtour.entity;

import java.util.Objects;

public class Hotel {

    private Long idHotel;
    private String hotelName;
    private City city;

    public Hotel() {
    }

    public Hotel(Long idHotel, String hotelName, City city) {
        this.idHotel = idHotel;
        this.hotelName = hotelName;
        this.city = city;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Hotel)) {
            return false;
        }
        Hotel hotel = (Hotel) o;
        return idHotel == hotel.idHotel &&
                hotelName == hotel.hotelName &&
                city == hotel.city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHotel, hotelName, city);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "idHotel=" + idHotel +
                ", hotelName='" + hotelName + '\'' +
                ", city=" + city +
                '}';
    }
}
