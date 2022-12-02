package com.businesstier.service.bill;

import com.businesstier.model.Bill;
import com.businesstier.network.billNetwork.BillOfClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService implements IBillService{

    private BillOfClient billOfClient;

    public BillService(BillOfClient billOfClient){
        this.billOfClient=billOfClient;
    }

    @Override
    public List<Bill> GetBillsForClient(int clientId) {
        return billOfClient.GetBillsForClient(clientId);
    }

    @Override
    public void CreateBill(Bill bill) {

    }

    @Override
    public void DeleteBill(Bill bill) {
        billOfClient.DeleteBill(bill);
    }

    @Override
    public void DeleteBillById(int billId) {
        billOfClient.DeleteBillById(billId);
    }
}
