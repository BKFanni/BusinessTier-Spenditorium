package com.businesstier.service;

import com.businesstier.model.Bill;
import com.businesstier.model.Client;
import com.businesstier.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService{
    ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }
    @Override
    public Client create(Client client) {
        return (Client) clientRepository.save(client);
    }


    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Iterable<Client> findAllItr() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client update(Client client) {
        return (Client) clientRepository.save(client);
    }

    @Override
    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }

   @Override
    public Boolean existsByUsername(String username) {
        return clientRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return clientRepository.existsByEmail(email);
    }

    @Override
    public Boolean getAccessLogin(String username, String password) {
        return clientRepository.getAccessLogin(username,password);
    }

    @Override
    public Optional<Bill> getBillById(int id) {
        return clientRepository.getBillById(id);
    }
}
