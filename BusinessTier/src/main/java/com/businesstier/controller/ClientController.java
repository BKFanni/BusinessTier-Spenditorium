package com.businesstier.controller;

import com.businesstier.model.Client;
import com.businesstier.service.client.ClientService;
import com.businesstier.service.client.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService service;

    public ClientController(ClientService clientService){
        service=clientService;
    }

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity register(@RequestBody Client client){
        try{
            String client1 = service.CreateClientAccount(client);
            return new ResponseEntity(client1, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/login", consumes = "application/json")
    public ResponseEntity getClient(@RequestBody Client client){

        try{
            Client client1 = service.GetClient(client.getUsername(), client.getPassword());
            return new ResponseEntity(client1, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{clientId}")
    public void deleteClient(@PathVariable int clientId){
        service.DeleteClient(clientId);
    }

    @GetMapping(value = "/accounts", consumes = "application/json")
    public ResponseEntity getClientByUsername(@RequestParam("Username") String username){
        try{
            Client client = service.GetClientByUsername(username);
            return new ResponseEntity(client, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/accounts/{clientId}", consumes = "application/json")
    public ResponseEntity getClientById(@PathVariable int clientId){
        try{
            Client client = service.GetClientById(clientId);
            return new ResponseEntity(client, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }



}
