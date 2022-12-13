package com.businesstier.controller;

import com.businesstier.model.Bill;
import com.businesstier.model.Client;
import com.businesstier.service.client.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/client")
public class ClientController {

    private Logger logger= LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientService service;

    public ClientController(ClientService clientService){
        service=clientService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/register", consumes = MediaType.ALL_VALUE)
    public ResponseEntity register(@RequestBody Client client){
        try{
            System.out.println(client);
            service.CreateClientAccount(client);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }


    /**
     * User login: decoding String value (userlogindto) containing username and password and sends credentials
     * to Tier3, if user credentials are valid return HTTP.OK response, otherwise HTTP.NOT_FOUND
     * @param userlogindto
     * @return
     */
    @PostMapping(value = "/login", consumes = MediaType.ALL_VALUE)
    public ResponseEntity login(@RequestBody String userlogindto){
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(userlogindto);
            String decodedString = new String(decodedBytes);
            int splitindex=decodedString.indexOf("/");
            String username=decodedString.substring(0,splitindex);
            String password=decodedString.substring(splitindex);
            Client client=service.GetClient(username,password);
            return new ResponseEntity(client.getId(),HttpStatus.OK);

        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
            return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    //STATISTICS
    @GetMapping(value = "/statistics/average/{provider},{year}")
    public ResponseEntity getAverageConsumptionByYear(@RequestParam("clientid") int clientid, @PathVariable("provider") String provider, @PathVariable("year") int year){
        try{
            Client client = service.GetClientById(clientid);
            return new ResponseEntity(GetAverageConsumption(clientid,provider,year),HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * GetAverageConsumption: Calculates the average consumption of a client for a specified provider and year
     * e.g. Calculate average electricity consumption in 2022
     * @param clientid
     * @param provider
     * @param year
     * @return
     */
    public double GetAverageConsumption(int clientid, String provider, int year){
        Client client=service.GetClientById(clientid);
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
    public ResponseEntity getTotalConsumptionByYear(@RequestParam("clientid") int clientid, @PathVariable("provider") String provider, @PathVariable("year") int year){
        try{
            Client client = service.GetClientById(clientid);
            return new ResponseEntity(GetTotalConsumptionByYear(clientid,provider,year),HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * GetTotalConsumptionByYear: Calculates the total consumption of a client for a specified provider and year
     * e.g. Calculate total electricity consumption in 2022
     * @param clientid
     * @param provider
     * @param year
     * @return
     */
    public double GetTotalConsumptionByYear(int clientid, String provider, int year){
        Client client=service.GetClientById(clientid);
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
    public ResponseEntity getConsumptionForMonthByYear(@RequestParam("clientid") int clientid, @PathVariable("provider") String provider, @PathVariable("year") int year, @PathVariable("month") int month){
        try{
            Client client = service.GetClientById(clientid);
            return new ResponseEntity(GetConsumptionForMonthByYear(clientid,provider,year,month),HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * GetConsumptionForMonthByYear: Returns the consumption for a specified provider, year and month
     * e.g. Calculate water consumption in 2022 February
     * @param clientid
     * @param provider
     * @param year
     * @param month
     * @return
     */
    public double GetConsumptionForMonthByYear(int clientid, String provider,int year, int month){
        Client client=service.GetClientById(clientid);
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
