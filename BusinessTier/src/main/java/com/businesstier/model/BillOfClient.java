package com.businesstier.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillOfClient {

    @JsonProperty
    private int  billId;

    @JsonProperty
    private int clientId;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
