package com.softserve.academy.dreamtour.entity;

import java.util.Objects;

public class Country {

    private int countryId;
    private String countryName;

    public Country() {
    }

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public Country(int countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, countryName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Country)) {
            return false;
        }

        Country country = (Country) obj;
        return countryId == country.countryId
                && Objects.equals(countryName, country.countryName);


    }

    @Override
    public String toString() {
        return "Country [ country id: " + countryId + ", country name: " + countryName + "]";
    }
}
