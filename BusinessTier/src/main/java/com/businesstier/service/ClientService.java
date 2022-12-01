package com.businesstier.service;

import com.businesstier.model.Bill;
import com.businesstier.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service// shorthand for @Bean to register OrderService interface as a bean
public interface ClientService{
    Client create(Client client);

    List<Client> findAll();  //  use List or Iterable
    Iterable<Client> findAllItr(); // use List or Iterable
    Optional<Client> findById(int id);
    Client update(Client client);
    void deleteById(int id);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    //LOGIN
   Boolean getAccessLogin(String username, String password);

    Optional<Bill> getBillById(int id);

}
