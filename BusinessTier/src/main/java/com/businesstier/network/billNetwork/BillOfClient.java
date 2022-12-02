package com.businesstier.network.billNetwork;

import com.businesstier.model.Bill;

import java.util.List;

public interface BillOfClient {
    List<Bill> GetBillsForClient(int clientId);
    void CreateBill(Bill bill);

    void DeleteBill(Bill bill);

    void DeleteBillById(int billId);
}
