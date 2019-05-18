package com.softserve.academy.dreamtour.entity;

import java.util.Objects;

public class City {

    private int cityId;
    private String cityName;
    private Country country;

    public City() {
    }

    public City(int cityId, String cityName, Country country) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.country = country;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName, country);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof City)) {
            return false;
        }

        City city = (City) obj;
        return cityId == city.cityId
                && Objects.equals(cityName, city.cityName)
                && Objects.equals(country, city.country);

    }

    @Override
    public String toString() {
        return "City [ city id: " + cityId + ", city name: " + cityName + ", " + country.toString() + "]";
    }
}
