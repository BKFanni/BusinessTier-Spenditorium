package com.businesstier.network.clientNetwork;

import com.businesstier.model.Client;

public interface ClientAccount {
    Client GetClient(String username, String password);

    String CreateClientAccount(Client client);

    void DeleteClient(int id);

    Client GetClientByUsername(String username);

    Client GetClientById(int id);

}
