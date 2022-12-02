package com.businesstier.service.bill;

import com.businesstier.model.Bill;

import java.util.List;

public interface IBillService {
    List<Bill> GetBillsForClient(int clientId);

    void CreateBill(Bill bill);

    void DeleteBill(Bill bill);

    void DeleteBillById(int burialId);
}
