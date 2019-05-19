package com.softserve.academy.dreamtour.entity;

import java.util.Objects;

public class Hotel {

    private int idHotel;
    private String hotelName;
    private String hotelDescription;
    private String imageUrl;
    private int stars;
    private int idCity;

    public Hotel() {
    }

    public Hotel(int idHotel, String hotelName, String hotelDescription, String imageUrl, int stars, int idCity) {
        this.idHotel = idHotel;
        this.hotelName = hotelName;
        this.hotelDescription = hotelDescription;
        this.imageUrl = imageUrl;
        this.stars = stars;
        this.idCity = idCity;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
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
        return idHotel == hotel.idHotel
            && stars == hotel.stars
            && idCity == hotel.idCity
            && Objects.equals(hotelName, hotel.hotelName)
            && Objects.equals(hotelDescription, hotel.hotelDescription)
            && Objects.equals(imageUrl, hotel.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHotel, hotelName, hotelDescription, imageUrl, stars, idCity);
    }

    @Override
    public String toString() {
        return "Hotel{"
            + "idHotel=" + idHotel
            + ", hotelName='" + hotelName + '\''
            + ", hotelDescription='" + hotelDescription + '\''
            + ", imageUrl='" + imageUrl + '\''
            + ", stars=" + stars
            + ", idCity=" + idCity
            + '}';
    }
}
