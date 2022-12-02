package com.businesstier.network.managerNetwork;

import com.businesstier.model.Manager;

public interface ManagerAccount {

    String CreateManagerAccount(Manager manager);
    Manager GetManager(String username, String password);

    void DeleteManager(int id);

    Manager GetManagerByUsername(String username);

    Manager GetManagerById(int id);
}
