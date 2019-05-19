package com.softserve.academy.dreamtour.entity;

import java.util.Objects;

public class Visa {
    
    private int idVisa;
    private int idPerson;
    private int idCountry;

    
    public Visa() { }
    
    public Visa(int idPerson, int idCountry) {
        this.idPerson = idPerson;
        this.idCountry = idCountry;
    }

    public Visa(int idVisa, int idPerson, int idCountry) {
        this.idVisa = idVisa;
        this.idPerson = idPerson;
        this.idCountry = idCountry;
    }

    
    public int getIdVisa() {
        return idVisa;
    }

    public void setIdVisa(int idVisa) {
        this.idVisa = idVisa;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
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
                && idPerson == visa.idPerson 
                && idCountry == visa.idCountry;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVisa, idPerson, idCountry);
    }
    
    @Override
    public String toString() {
        return "Visa [" 
                + "idVisa=" + idVisa 
                + ", idPerson=" + idPerson 
                + ", idCountry" + idCountry 
                + "]";
    }
    
}