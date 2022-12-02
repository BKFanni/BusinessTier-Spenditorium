package com.businesstier.service.client;

import com.businesstier.model.Client;
import com.businesstier.network.clientNetwork.ClientAccount;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService{
    private ClientAccount clientAccount;

    public ClientService(ClientAccount clientAccount){
        this.clientAccount=clientAccount;
    }

    @Override
    public Client GetClient(String username, String password) throws IllegalAccessException {
        if(clientAccount.GetClient(username, password).getUsername().equals(username) && clientAccount.GetClient(username, password).getPassword().equals(password))
            return clientAccount.GetClient(username, password);

        throw new IllegalAccessException("Not found. Check credentials");
    }

    @Override
    public String CreateClientAccount(Client client) {
       return clientAccount.CreateClientAccount(client);
    }

    @Override
    public void DeleteClient(int id) {
        clientAccount.DeleteClient(id);
    }

    @Override
    public Client GetClientByUsername(String username) {
        return clientAccount.GetClientByUsername(username);
    }

    @Override
    public Client GetClientById(int id) {
        return clientAccount.GetClientById(id);
    }
}
