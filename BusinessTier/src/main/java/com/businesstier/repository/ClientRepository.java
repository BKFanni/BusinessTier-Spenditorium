package com.businesstier.repository;

import com.businesstier.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
//<Client, Integer extends Serializable>
@Repository
public interface ClientRepository<T,Integer extends Serializable> extends JpaRepository<T, Integer> {
 com.businesstier.model.Client findByUsername(String username);

 Boolean existsByUsername(String username);

 Boolean existsByEmail(String email);

 //LOGIN
 Boolean getAccessLogin(String username, String password);
 }
