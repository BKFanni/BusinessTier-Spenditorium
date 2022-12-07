package com.businesstier.controller;

import com.auth0.jwt.JWT;
import com.businesstier.model.Client;
import com.businesstier.service.client.ClientService;
import com.businesstier.service.client.IClientService;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;


@RestController
@RequestMapping("/client")
public class ClientController {

    private Logger logger= LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientService service;

    public ClientController(ClientService clientService){
        service=clientService;
    }

    @CrossOrigin("*")
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

    //Change to jwt token
   /* @GetMapping(value = "/login", consumes = MediaType.ALL_VALUE)
    public ResponseEntity getClient(@RequestBody JWT token, @RequestBody String secretKey){
        try{
            Client client1 = service.GetClient(client.getUsername(), client.getPassword());
            return new ResponseEntity(client1, HttpStatus.OK);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }*/

    //STATISTICS

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
