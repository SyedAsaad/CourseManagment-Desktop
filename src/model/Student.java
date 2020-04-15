package model;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asaad
 */
public class Student {
    
    private Long id;
    private String name;
    private String category;
    private String phoneNumber;
    private String country;
    private String city;
    private String dob;
    private String gender;

    public Student() {
    }

    public Student(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public Student(String name, String category, String phoneNumber, String country, String city, String dob, String gender) {
        this.name = name;
        this.category = category;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.dob = dob;
        this.gender = gender;
    }
    
    
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
