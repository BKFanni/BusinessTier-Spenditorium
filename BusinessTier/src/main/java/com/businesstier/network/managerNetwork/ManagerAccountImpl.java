package com.businesstier.network.managerNetwork;

import com.businesstier.model.Manager;
import com.businesstier.network.communication.SocketClient;
import com.businesstier.network.utility.NetworkPackage;
import com.businesstier.network.utility.NetworkType;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagerAccountImpl implements ManagerAccount{
    @Autowired
    SocketClient socket;

    @Override
    public String CreateManagerAccount(Manager manager) {
        Gson gson = new Gson();
        String serializedManager = gson.toJson(manager);
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.REGISTER, serializedManager);
        return socket.communicate(networkPackage);
    }

    @Override
    public Manager GetManager(String username, String password) {
        Gson gson = new Gson();
        Manager manager=new Manager();
        manager.setUsername(username);
        manager.setPassword(username);
        String serializedAccount = gson.toJson(manager);
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.LOGINMANAGER, serializedAccount);
        String input = socket.communicate(networkPackage);
        return gson.fromJson(input, Manager.class);
    }

    @Override
    public void DeleteManager(int id) {
        Gson gson = new Gson();
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.DELETEMANAGER, String.valueOf(id));
        socket.communicate(networkPackage);
    }

    @Override
    public Manager GetManagerByUsername(String username) {
        Gson gson = new Gson();
        Manager manager=new Manager();
        manager.setUsername(username);

        String serializedManager = gson.toJson(manager);
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.GETMANAGERBYUSERNAME, serializedManager);
        String input = socket.communicate(networkPackage);

        return gson.fromJson(input, Manager.class);
    }

    @Override
    public Manager GetManagerById(int id) {
        Gson gson = new Gson();
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.GETMANAGERBYID, String.valueOf(
                id));
        String input = socket.communicate(networkPackage);
        return gson.fromJson(input, Manager.class);
    }
}
