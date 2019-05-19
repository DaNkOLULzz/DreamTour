package com.softserve.academy.dreamtour.entity;

import java.util.Objects;

public class City {

    private int cityId;
    private String cityName;
    private int countryId;

    public City() {
    }

    public City(int cityId, String cityName, int countryId) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.countryId = countryId;
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

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName, countryId);
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
                && countryId== city.countryId;

    }

    @Override
    public String toString() {
        return "City [ city id: " + cityId + ", city name: " + cityName + ", " + countryId + "]";
    }
}
