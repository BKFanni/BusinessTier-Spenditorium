package com.businesstier.service;
import com.businesstier.model.Bill;
import com.businesstier.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService{

    @Override
    public Client create(Client client) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Iterable<Client> findAllItr() {
        return null;
    }

    @Override
    public Optional<Client> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

    @Override
    public Boolean getAccessLogin(String username, String password) {
        return null;
    }

    @Override
    public Optional<Bill> getBillById(int id) {
        return Optional.empty();
    }
}
