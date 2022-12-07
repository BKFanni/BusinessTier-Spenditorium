package com.businesstier.network.clientNetwork;

import com.businesstier.model.Client;
import com.businesstier.network.communication.SocketClient;
import com.businesstier.network.utility.NetworkPackage;
import com.businesstier.network.utility.NetworkType;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientAccountImpl implements ClientAccount{

    @Autowired
    SocketClient socketClient;
    @Override
    public Client GetClient(String username, String password) {
        Gson gson = new Gson();
        Client client = new Client();
        client.setUsername(username);
        client.setPassword(password);
        String serializedAccount = gson.toJson(client);
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.LOGIN, serializedAccount);
        String input = socketClient.communicate(networkPackage);
        return gson.fromJson(input, Client.class);
    }

    @Override
    public String CreateClientAccount(Client client) {
        Gson gson = new Gson();
        String serializedClient = gson.toJson(client);
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.REGISTER, serializedClient);
        return socketClient.communicate(networkPackage);
    }

    @Override
    public void DeleteClient(int id) {
        Gson gson = new Gson();
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.DELETECLIENT, String.valueOf(id));
        socketClient.communicate(networkPackage);
    }

    @Override
    public Client GetClientByUsername(String username) {
        Gson gson = new Gson();
        Client client = new Client();
        client.setUsername(username);

        String serializedClient = gson.toJson(client);
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.GETCLIENTBYUSERNAME, serializedClient);
        String input = socketClient.communicate(networkPackage);

        return gson.fromJson(input, Client.class);
    }

    @Override
    public Client GetClientById(int id) {
        Gson gson = new Gson();
        Client client = new Client();
        client.setId(id);
        String serializedClient = gson.toJson(client);
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.GETCLIENTBYID,serializedClient);
        String input = socketClient.communicate(networkPackage);
        return gson.fromJson(input, Client.class);
    }
}
