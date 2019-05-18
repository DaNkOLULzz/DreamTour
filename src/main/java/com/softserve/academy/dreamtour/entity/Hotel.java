package com.softserve.academy.dreamtour.entity;

import java.util.Objects;

public class Hotel {

    private int idHotel;
    private String hotelName;
    private String hotelDescription;
    private String imageUrl;
    private int stars;
    private City city;

    public Hotel() {
    }

    public Hotel(int idHotel, String hotelName,
                 String hotelDescription, String imageUrl, int stars, City city) {
        this.idHotel = idHotel;
        this.hotelName = hotelName;
        this.hotelDescription = hotelDescription;
        this.imageUrl = imageUrl;
        this.stars = stars;
        this.city = city;
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
        return idHotel == hotel.idHotel
            && stars == hotel.stars
            && hotelName.equals(hotel.hotelName)
            && Objects.equals(hotelDescription, hotel.hotelDescription)
            && imageUrl.equals(hotel.imageUrl)
            && Objects.equals(city, hotel.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHotel, hotelName, hotelDescription, imageUrl, stars, city);
    }

    @Override
    public String toString() {
        return "Hotel{"
            + "idHotel=" + idHotel
            + ", hotelName='" + hotelName + '\''
            + ", hotelDescription='" + hotelDescription + '\''
            + ", imageUrl='" + imageUrl + '\''
            + ", stars=" + stars
            + ", city=" + city
            + '}';
    }
}
