package com.businesstier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.util.List;


public class Client {

    @JsonProperty
    private int id;

    @JsonProperty
    private String username;

    @JsonProperty
    private String password;

    @JsonProperty
    private String name;

    @JsonProperty
    private String email;

    @JsonProperty
    private Date dob;

    @JsonProperty
    private int phonenumber;

    @JsonProperty
    private List<Bill> bills;

    @JsonProperty
    private boolean isSubToElectricity;
    @JsonProperty
    private boolean isSubToWater;
    @JsonProperty
    private boolean isSubToHeating;
    @JsonProperty
    private boolean isSubToRent;

    public Client(String username, String password){
        this.username=username;
        this.password=password;

        this.isSubToElectricity = false;
        this.isSubToWater = false;
        this.isSubToHeating = false;
        this.isSubToRent = false;
    }

    public Client(){}

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

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
