package com.softserve.academy.dreamtour.entity;

import java.util.Objects;

public class Visa {
    
    private Long idVisa;
    private Tourist tourist;
    private Country country;


    public Visa(Long idVisa, Tourist tourist, Country country) {
        this.idVisa = idVisa;
        this.tourist = tourist;
        this.country = country;
    }

    
    public Long getIdVisa() {
        return idVisa;
    }


    public void setIdVisa(Long idVisa) {
        this.idVisa = idVisa;
    }


    public Tourist getTourist() {
        return tourist;
    }


    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }


    public Country getCountry() {
        return country;
    }


    public void setCountry(Country country) {
        this.country = country;
    }


    @Override
    public boolean equals(Object o) {

        if (o == this) { return true; }
        
        if ((o instanceof Tourist) == false) {
            return false;
        }
   
        Visa visa = (Visa) o;
        
        return idVisa == visa.idVisa &&
                Objects.equals(tourist, visa.tourist) &&
                Objects.equals(country, visa.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVisa, tourist, country);
    }
    
    @Override
    public String toString() {
        return "Visa [" +
                "idVisa=" + idVisa +
                ", " + tourist.toString() +
                ", " + country.toString() +
                "]";
    }
    
}