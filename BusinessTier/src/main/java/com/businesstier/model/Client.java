package com.businesstier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.type.DateTime;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    // You could also assign table column names
    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "FullName")
    private String name;

    @Column(name = "Email")
    private String email;


    @Column(name = "DOB")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @Column(name = "PhoneNumber")
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
