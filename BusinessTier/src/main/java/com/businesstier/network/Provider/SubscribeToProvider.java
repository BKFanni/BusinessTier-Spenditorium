package com.businesstier.network.Provider;

public interface SubscribeToProvider {
    void SubToAll();
    void SubToRent();
    void SubToElectricity();
    void SubToWater();
    void SubToHeating();

    void Unsubscribe(String provider);
}
