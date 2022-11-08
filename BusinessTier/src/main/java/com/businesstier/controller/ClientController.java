package com.businesstier.controller;

import com.businesstier.model.Client;
import com.businesstier.service.ClientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientController{
  private final Logger logger = LoggerFactory.getLogger(ClientController.class);
  private ClientServiceImpl clientService;
  public ClientController(ClientServiceImpl clientService) {
    this.clientService=clientService;
  }


  // http://localhost:8090/api/clients
  @PostMapping("/clients")
  public ResponseEntity<Object> createClient(@RequestBody Client client) {
    try {
      Client createdClient = clientService.create(client);
      return new ResponseEntity<Object>(createdClient, HttpStatus.OK);
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
  }

    @GetMapping("/clients")
    public ResponseEntity<Object> getAllClients(){
      try {
        Iterable<Client> clients = clientService.findAllItr();
        return new ResponseEntity<Object>(clients, HttpStatus.OK);
      } catch (Exception ex) {
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
      }
  }
  @GetMapping(value="/clienta/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getClientById(@PathVariable("id") int id){
    try {
      Optional<Client> client= clientService.findById(id);
      if (client.isPresent()) {
        return new ResponseEntity<Object>(client.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/clients/{id}")
  public ResponseEntity<Object> updateClient(@PathVariable("id") int id, @RequestBody Client client){
    try {
      client.setId(id);
      Client savedClient = clientService.update(client);
      return new ResponseEntity<Object>(savedClient, HttpStatus.OK);
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("/clients/{id}")
  public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") int id){
    try {
      clientService.deleteById(id);
      return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
    }
  }





}
