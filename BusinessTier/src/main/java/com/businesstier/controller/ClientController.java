package com.businesstier.controller;

import com.businesstier.model.Bill;
import com.businesstier.model.Client;
import com.businesstier.security.AuthRequest;
import com.businesstier.security.JwtUtil;
import com.businesstier.service.client.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:7172")
@RequestMapping("/client")
public class ClientController {

    private Logger logger= LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    ClientService service;

    public ClientController(ClientService clientService){
        service=clientService;
    }




    @PostMapping(value = "/register", consumes = MediaType.ALL_VALUE)
    public ResponseEntity register(@RequestBody Client client){
        try{ System.out.println(client);
            String client1 = service.CreateClientAccount(client);
            System.out.println(client);
            return new ResponseEntity(client1, HttpStatus.OK);
        }
        catch(Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


    @PostMapping(value = "/login", consumes = MediaType.ALL_VALUE)
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }

    //STATISTICS
    @GetMapping(value = "/statistics/average/{provider},{year}")
    public ResponseEntity getAverageConsumptionByYear(@RequestParam("username") String username, @PathVariable("provider") String provider, @PathVariable("year") int year){
        try{
            Client client = service.GetClientByUsername(username);
            return new ResponseEntity(GetAverageConsumption(username,provider,year),HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    public double GetAverageConsumption(String username, String provider, int year){
        Client client=service.GetClientByUsername(username);
        List<Bill> bills=client.getBills();
        List<Bill> list=new ArrayList<Bill>();
        for (int i = 0; i < bills.size(); i++) {
            if(bills.get(i).getProvider().equals(provider))
            {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(bills.get(i).getBillingdate());
                int yearbill=calendar.get(Calendar.YEAR);

                if(yearbill==year){
                    list.add(bills.get(i));
                }
            }
        }

        double sum=0;

        for (int i = 0; i < list.size(); i++) {
            sum=sum+list.get(i).getAmount();
        }

        sum=sum/12;

        return sum;
    }


    @GetMapping(value = "/statistics/total/{provider},{year}")
    public ResponseEntity getTotalConsumptionByYear(@RequestParam("username") String username, @PathVariable("provider") String provider, @PathVariable("year") int year){
        try{
            Client client = service.GetClientByUsername(username);
            return new ResponseEntity(GetTotalConsumptionByYear(username,provider,year),HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    public double GetTotalConsumptionByYear(String username, String provider, int year){
        Client client=service.GetClientByUsername(username);
        List<Bill> bills=client.getBills();
        List<Bill> list=new ArrayList<Bill>();
        for (int i = 0; i < bills.size(); i++) {
            if(bills.get(i).getProvider().equals(provider))
            {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(bills.get(i).getBillingdate());
                int yearbill=calendar.get(Calendar.YEAR);

                if(yearbill==year){
                    list.add(bills.get(i));
                }
            }
        }

        double sum=0;

        for (int i = 0; i < list.size(); i++) {
            sum=sum+list.get(i).getAmount();
        }

        return sum;
    }


    @GetMapping(value = "/statistics/monthly/{provider},{year},{month}")
    public ResponseEntity getConsumptionForMonthByYear(@RequestParam("username") String username, @PathVariable("provider") String provider, @PathVariable("year") int year, @PathVariable("month") int month){
        try{
            Client client = service.GetClientByUsername(username);
            return new ResponseEntity(GetConsumptionForMonthByYear(username,provider,year,month),HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    public double GetConsumptionForMonthByYear(String username, String provider,int year, int month){
        Client client=service.GetClientByUsername(username);
        List<Bill> bills=client.getBills();
        Bill existing=new Bill();
        for (int i = 0; i < bills.size(); i++) {
            if(bills.get(i).getProvider().equals(provider))
            {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(bills.get(i).getBillingdate());
                int monthbill=calendar.get(Calendar.MONTH);
                int yearbill=calendar.get(Calendar.YEAR);

                if(yearbill==year && monthbill==month) {
                    existing = bills.get(i);
                }
            }
        }
        return existing.getAmount();
    }


    @DeleteMapping("/delete/{clientId}")
    public void deleteClient(@PathVariable int clientId){
        service.DeleteClient(clientId);
    }

    @GetMapping(value = "/accounts")
    public ResponseEntity getClientByUsername(@RequestParam("username") String username){
        try{
            Client client = service.GetClientByUsername(username);
            return new ResponseEntity(client, HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/accounts/{clientId}")
    public ResponseEntity getClientById(@PathVariable int clientId){
        try{
            Client client = service.GetClientById(clientId);
            return new ResponseEntity(client, HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }



}
