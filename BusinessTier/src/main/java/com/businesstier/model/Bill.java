package com.businesstier.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Bill {

    @JsonProperty
    private int id;

    @JsonProperty
    private double amountUsed;

    @JsonProperty
    private double totalPrice;

    @JsonProperty
    private int clientId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(double amountUsed) {
        this.amountUsed = amountUsed;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
