package com.businesstier;


import com.businesstier.network.communication.ClientConnection;
import com.businesstier.network.communication.SocketClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusinessTierApplication {

    public static void main(String[] args) {
        SocketClient client = new ClientConnection();
        client.startClient();
        SpringApplication.run(BusinessTierApplication.class, args);
    }

}
