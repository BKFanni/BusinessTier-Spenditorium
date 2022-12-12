package com.businesstier;


import com.businesstier.network.communication.ClientConnection;
import com.businesstier.network.communication.SocketClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BusinessTierApplication {

    public static void main(String[] args) {
        SocketClient client = new ClientConnection();
        client.startClient();
        SpringApplication.run(BusinessTierApplication.class, args);
    }

    /*@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("register-javaconfig").allowedOrigins("*");
            }
        };
    }*/
}
