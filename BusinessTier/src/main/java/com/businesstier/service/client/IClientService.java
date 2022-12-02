package com.businesstier.service.client;

import com.businesstier.model.Client;

public interface IClientService {
    Client GetClient(String username, String password)
            throws IllegalAccessException;

    String CreateClientAccount(Client client);

    void DeleteClient(int id);

    Client GetClientByUsername(String username);

    Client GetClientById(int id);
}
