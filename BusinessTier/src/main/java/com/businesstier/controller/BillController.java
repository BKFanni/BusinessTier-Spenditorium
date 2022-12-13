package com.businesstier.controller;


import com.businesstier.model.Bill;
import com.businesstier.service.bill.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("localhost:7172")
@RestController
@RequestMapping("")
public class BillController {
    private Logger logger= LoggerFactory.getLogger(BillController.class);
    @Autowired
    BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping(value = "/bills", produces = "application/json")
    public void AddBill(@RequestBody Bill bill){
        billService.CreateBill(bill);
    }

    @GetMapping(value = "/allbills", consumes = "application/json")
    public List<Bill> getBill(@RequestParam("clientId") int clientId){
        return billService.GetBillsForClient(clientId);
    }

    @GetMapping(value = "/bills", consumes = "application/json")
    public List<Bill> getBillsByProvider(@RequestParam("clientId") int clientid, @RequestParam("provider") String provider){
        List<Bill> list= billService.GetBillsForClient(clientid);
        List<Bill> listByProvider=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getProvider().equals(provider)){
                listByProvider.add(list.get(i));
            }
        }
        return listByProvider;
    }

    @DeleteMapping(value = "/bills/{billId}", consumes = "application/json")
    public void deleteBillById(@PathVariable int billId){
        billService.DeleteBillById(billId);
    }

    @DeleteMapping(value = "/bills/{bill}", consumes = "application/json")
    public void deleteBill(@PathVariable Bill bill){
        billService.DeleteBill(bill);
    }


}
