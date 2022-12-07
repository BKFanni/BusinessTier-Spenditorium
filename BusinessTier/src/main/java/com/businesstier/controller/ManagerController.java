package com.businesstier.controller;

import com.businesstier.model.Client;
import com.businesstier.model.Manager;
import com.businesstier.service.manager.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("localhost:7172")
@RestController
@RequestMapping("/manager")
public class ManagerController {
    private Logger logger= LoggerFactory.getLogger(ClientController.class);

    @Autowired private ManagerService service;

    public ManagerController(ManagerService service){
        this.service=service;
    }

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity register(@RequestBody Manager manager){
        try{
            String manager1 = service.CreateManagerAccount(manager);
            return new ResponseEntity(manager1, HttpStatus.OK);
        }
        catch(Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping( value = "/login", consumes = "application/json")
    public Manager getManager(@RequestBody Manager manager){
        return service.GetManager(manager.getUsername(), manager.getPassword());
    }

    @GetMapping(value = "/accounts", consumes = "application/json")
    public Manager getManagerByUsername(@RequestParam("username") String username){
        return service.GetManagerByUsername(username);
    }

    @GetMapping(value = "/accounts/{managerId}", consumes = "application/json")
    public Manager getManagerById(@PathVariable int managerId){
        return service.GetManagerById(managerId);
    }

    @DeleteMapping("/delete/{managerId}")
    public void deleteManager(@PathVariable int managerId){
        service.DeleteManager(managerId);
    }

}
