package com.businesstier.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
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
    private String dob;

    @JsonProperty
    private String phonenumber;

    @JsonProperty
    private List<Bill> bills=new ArrayList<>();

    @JsonProperty
    private Boolean[] subscriptions;
    public Client(String username, String password){
        this.username =username;
        this.password=password;
    }

    public Client(){
        subscriptions = new Boolean[]{false, false, false, false};
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }


}
