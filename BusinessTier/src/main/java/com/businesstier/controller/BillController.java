package com.businesstier.controller;


import com.businesstier.model.Bill;
import com.businesstier.service.bill.BillService;
import com.businesstier.service.bill.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("")
public class BillController {

    @Autowired
    BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping(value = "/bills", produces = "application/json")
    public void AddBill(@RequestBody Bill bill){
        billService.CreateBill(bill);
    }

    @GetMapping(value = "/bills", consumes = "application/json")
    public List<Bill> getBill(@RequestParam("clientId") int clientId){
        return billService.GetBillsForClient(clientId);
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
