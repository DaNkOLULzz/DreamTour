package com.softserve.academy.dreamtour.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Visa {
    
    private int idVisa;
    private int idPerson;
    private int idCountry;
    private LocalDate endDate;

    
    public Visa() { }
    
    public Visa(int idPerson, int idCountry, LocalDate endDate) {
        this.idPerson = idPerson;
        this.idCountry = idCountry;
        this.endDate = endDate;
    }

    public Visa(int idVisa, int idPerson, int idCountry, LocalDate endDate) {
        this.idVisa = idVisa;
        this.idPerson = idPerson;
        this.idCountry = idCountry;
        this.endDate = endDate;
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
    
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
                && idCountry == visa.idCountry
                && endDate.equals(visa.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVisa, idPerson, idCountry, endDate);
    }
    
    @Override
    public String toString() {
        return "Visa [" 
                + "idVisa=" + idVisa 
                + ", idPerson=" + idPerson 
                + ", idCountry=" + idCountry
                + ", endDate=" + endDate
                + "]";
    }
    
}