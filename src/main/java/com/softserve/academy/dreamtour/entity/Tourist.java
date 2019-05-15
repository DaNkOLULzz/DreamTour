package com.softserve.academy.dreamtour.entity;

import java.util.Objects;

public class Tourist {
    
    private Long idTourist;
    private String firstName;
    private String lastName;

    
    public Tourist(Long idTourist, String firstName, String lastName) {
        this.idTourist = idTourist;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getIdTourist() {
        return idTourist;
    }

    public void setIdTourist(Long idTourist) {
        this.idTourist = idTourist;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) { return true; }
        
        if ((o instanceof Tourist) == false) {
            return false;
        }
   
        Tourist tourist = (Tourist) o;
        
        return idTourist == tourist.idTourist &&
                Objects.equals(firstName, tourist.firstName) &&
                Objects.equals(lastName, tourist.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTourist, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Tourist [" +
                "idTourist=" + idTourist +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                "]";
    }
    
}