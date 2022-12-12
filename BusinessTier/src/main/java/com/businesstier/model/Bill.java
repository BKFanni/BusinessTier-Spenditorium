package com.businesstier.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Bill {

    @JsonProperty
    private int id;

    @JsonProperty
    private java.util.Date billingdate;

    @JsonProperty
    private java.util.Date duedate;

    @JsonProperty
    private double amount;

    @JsonProperty
    private double total;

    @JsonProperty
    private double priceperitem;

    @JsonProperty
    private int clientid;

    @JsonProperty
    private String provider;

    @JsonProperty
    private boolean paidstatus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }


    public Date getBillingdate() {
        return billingdate;
    }

    public void setBillingdate(Date billingdate) {
        this.billingdate = billingdate;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public double getPriceperitem() {
        return priceperitem;
    }

    public void setPriceperitem(double priceperitem) {
        this.priceperitem = priceperitem;
    }

    public boolean isPaidstatus() {
        return paidstatus;
    }

    public void setPaidstatus(boolean paidstatus) {
        this.paidstatus = paidstatus;
    }
}
