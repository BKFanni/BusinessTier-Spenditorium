package com.businesstier.network.billNetwork;

import com.businesstier.model.Bill;
import com.businesstier.network.communication.SocketClient;
import com.businesstier.network.utility.NetworkPackage;
import com.businesstier.network.utility.NetworkType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillOfClientImpl implements BillOfClient{
    @Autowired
    SocketClient socket;
    @Override
    public List<Bill> GetBillsForClient(int clientId) {
        Gson gson = new Gson();
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.BILLS, String.valueOf(clientId));
        String input = socket.communicate(networkPackage);
        System.out.println(input);
        return gson.fromJson(input, new TypeToken<List<ProjectInfoProperties.Build>>() {
        }.getType());
    }

    @Override
    public void CreateBill(Bill bill) {
        Gson gson = new Gson();
        String serializedBill = gson.toJson(bill);
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.ADDBILL, serializedBill);
        socket.communicate(networkPackage);
    }

    @Override
    public void DeleteBill(Bill bill) {
        Gson gson = new Gson();
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.DELETEBILL, String.valueOf(bill));
        socket.communicate(networkPackage);
    }

    @Override
    public void DeleteBillById(int billId) {
        Gson gson = new Gson();
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.DELETEBILLBYID, String.valueOf(billId));
        socket.communicate(networkPackage);
    }
}
