package com.assecor.usermanager.bean;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String zipcode;
    private String city;
    private String color;

    public User(Long id, String firstName, String lastName, String zipcode, String city, String favouriteColorCode) {
        this.id = id;
        this.name = firstName;
        this.lastName = lastName;
        this.zipcode = zipcode;
        this.city = city;
        this.color = favouriteColorCode;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Id = " + id + ""
                + " FirstName = " + name + ", lastName= " + lastName + " zipcode = " + zipcode + "City = " + city + " Favourite Color = " + color;
    }


}
