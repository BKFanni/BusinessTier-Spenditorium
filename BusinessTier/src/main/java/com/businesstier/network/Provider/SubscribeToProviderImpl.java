package com.businesstier.network.Provider;


import com.businesstier.network.communication.SocketClient;
import com.businesstier.network.utility.NetworkPackage;
import com.businesstier.network.utility.NetworkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubscribeToProviderImpl implements SubscribeToProvider{

    @Autowired
    SocketClient socketClient;

    @Override
    public void SubToAll() {
        SubToElectricity();
        SubToHeating();
        SubToRent();
        SubToWater();
    }

    @Override
    public void SubToRent() {
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.SUBTORENT,"RENT");
        socketClient.communicate(networkPackage);
    }

    @Override
    public void SubToElectricity() {
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.SUBTOELECTRICITY,"ELECTRICITY");
        socketClient.communicate(networkPackage);
    }

    @Override
    public void SubToWater() {
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.SUBTOWATER,"WATER");
        socketClient.communicate(networkPackage);
    }

    @Override
    public void SubToHeating() {
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.SUBTOHEATING,"HEATING");
        socketClient.communicate(networkPackage);
    }

    @Override
    public void Unsubscribe(String provider) {
        NetworkPackage networkPackage = new NetworkPackage(NetworkType.UNSUBSCRIBE,provider);
        socketClient.communicate(networkPackage);
    }

    @Override
    public void UnsubscribeFromAll() {
        Unsubscribe("RENT");
        Unsubscribe("WATER");
        Unsubscribe("HEATING");
        Unsubscribe("ELECTRICITY");
    }
}
