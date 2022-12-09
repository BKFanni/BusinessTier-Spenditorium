package com.businesstier.controller;

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


@RestController
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

    @CrossOrigin("*")
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
