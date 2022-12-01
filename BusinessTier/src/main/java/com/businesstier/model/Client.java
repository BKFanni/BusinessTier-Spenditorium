package com.businesstier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Date;


public class Client {


    private int id;

    private String username;


    private String password;


    private String name;


    private String email;



    private Date dob;


    private int phonenumber;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phonenumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", phoneNumber=" + phonenumber +
                '}';
    }
}
