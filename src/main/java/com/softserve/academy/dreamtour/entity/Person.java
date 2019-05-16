package com.softserve.academy.dreamtour.entity;

import java.util.Objects;

public class Person {
    
    private Long idPerson;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    public Person() { }

    public Person(Long idPerson, String username, String password, String firstName, String lastName) {
        this.idPerson = idPerson;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    
    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        
        if ((o instanceof Person) == false) {
            return false;
        }
   
        Person person = (Person) o;
        
        return idPerson == person.idPerson &&
                Objects.equals(username, person.username) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, username, password, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Person [" +
                "idPerson=" + idPerson +
                ", username=" + username +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                "]";
    }
    
}