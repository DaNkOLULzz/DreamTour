package com.softserve.academy.dreamtour.entity;

import java.util.Objects;

public class Visa {
    
    private int idVisa;
    private Person person;
    private Country country;

    
    public Visa() { }
    
    public Visa(int idVisa, Person person, Country country) {
        this.idVisa = idVisa;
        this.person = person;
        this.country = country;
    }

    
    public int getIdVisa() {
        return idVisa;
    }


    public void setIdVisa(int idVisa) {
        this.idVisa = idVisa;
    }


    public Person getPerson() {
        return person;
    }


    public void setPerson(Person person) {
        this.person = person;
    }


    public Country getCountry() {
        return country;
    }


    public void setCountry(Country country) {
        this.country = country;
    }


    @Override
    public boolean equals(Object o) {

        if (o == this) { 
            return true; 
        }
        
        if ((o instanceof Person) == false) {
            return false;
        }
   
        Visa visa = (Visa) o;
        
        return idVisa == visa.idVisa 
                && Objects.equals(person, visa.person) 
                && Objects.equals(country, visa.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVisa, person, country);
    }
    
    @Override
    public String toString() {
        return "Visa [" 
                + "idVisa=" + idVisa 
                + ", " + person.toString() 
                + ", " + country.toString() 
                + "]";
    }
    
}