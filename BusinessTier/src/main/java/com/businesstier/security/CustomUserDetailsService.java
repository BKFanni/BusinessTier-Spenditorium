package com.businesstier.security;

import com.businesstier.model.Client;
import com.businesstier.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client =clientService.GetClientByUsername(username);
        return new org.springframework.security.core.userdetails.User(client.getUsername(),client.getPassword(), new ArrayList<>());
    }
}
