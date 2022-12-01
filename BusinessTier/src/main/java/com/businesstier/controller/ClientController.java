package com.businesstier.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.businesstier.model.Bill;
import com.businesstier.model.Client;
import com.businesstier.model.ClientLogin;
import com.businesstier.service.ClientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.*;
import java.util.random.RandomGenerator;

import static javax.crypto.Cipher.SECRET_KEY;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
public class ClientController{
  private Logger logger = LoggerFactory.getLogger(ClientController.class);
  private ClientServiceImpl clientService;


@Autowired
  public ClientController(ClientServiceImpl clientService) {
    this.clientService = clientService;
  }

  // http://localhost:8090/


  @PostMapping(value = "/addNewClient", consumes = "application/json")
  public ResponseEntity<Object> createClient(@RequestBody Client client) {
    try {
      if(clientService.existsByUsername(client.getUsername())==true){
        throw new Exception("Client with this username '"+client.getUsername()+"' already exist.");
      }
      if(clientService.existsByEmail(client.getEmail())==true){
        throw new Exception("Client with this email '"+client.getEmail()+"' already exist.");
      }
      Client createdClient = clientService.create(client);
      System.out.println(client.getDob());
      return new ResponseEntity<Object>(createdClient, HttpStatus.OK);
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
  }

//{"username":"vlad","password":"12345","fullname":"Vladislav","email":"smile@gmail.com","dob":"2022-11-18","phonenumber":11111111}
//SHOULD RETURN A JWT TOKEN
  @GetMapping(value = "/login/{username}+{password}", produces = MediaType.APPLICATION_JSON_VALUE)
  public String getClientLogin(@PathVariable("username") String username, @PathVariable("password") String password, @RequestBody ClientLogin clientLogin) {
    try{
      if(clientService.getAccessLogin(username, password)==true) {
        //return createJWT(String.valueOf(clientLogin.getId()),username,password, RandomGenerator.getDefault().nextInt());
        /*try {
          Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
          String token = JWT.create()
                  .withIssuer("auth0")
                  .sign(algorithm);
        } catch (JWTCreationException exception){
          // Invalid Signing configuration / Couldn't convert Claims.
        }*/
        return null;
      }
      else return "Client credentials are incorrect. Could not find client with the given credentials.";
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      return ex.toString();
    }
  }
  public static String createJWT(String id, String issuer, String subject, long ttlMillis) {
/*
    //The JWT signature algorithm we will be using to sign the token
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);

    //We will sign our JWT with our ApiKey secretbyte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(String.valueOf(SECRET_KEY));
    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

    //Let's set the JWT Claims
    JwtBuilder builder = Jwts.builder().setId(id)
            .setIssuedAt(now)
            .setSubject(subject)
            .setIssuer(issuer)
            .signWith(signatureAlgorithm, signingKey);

    //if it has been specified, let's add the expiration
    if (ttlMillis > 0) {
      long expMillis = nowMillis + ttlMillis;
      Date exp = new Date(expMillis);
      builder.setExpiration(exp);
    }

    //Builds the JWT and serializes it to a compact, URL-safe string
    return builder.compact();*/
    return null;
  }



    @GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllClients(){
      try {
        Iterable<Client> clients = clientService.findAllItr();
        return new ResponseEntity<Object>(clients, HttpStatus.OK);
      } catch (Exception ex) {
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
      }
  }
  @GetMapping(value="/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getClientById(@PathVariable("id") int id){
    try {
      Optional<Client> client= clientService.findById(id);
      if (client.isPresent()) {
        return new ResponseEntity<Object>(client.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
  }



  @PutMapping(value = "/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> updateClient(@PathVariable("id") int id, @RequestBody Client client){
    try {
      System.out.println(client.toString());
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


  //BILL related methods

  /*@PostMapping(value = "/addBill/{clientId}",consumes = "application/json")
  public ResponseEntity<Object> addBillToClient(@RequestBody Bill bill) {
    try {
      Bill createdBill = clientService.addBill(bill);
      return new ResponseEntity<Object>(createdBill, HttpStatus.OK);
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
  }
*/

  @GetMapping(value = "/client/viewBill/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getBillById(@PathVariable("id") int id) {
    try{
      Optional<Bill> bill=clientService.getBillById(id);
      if (bill.isPresent()) {
        return new ResponseEntity<Object>(bill.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
  }
}
