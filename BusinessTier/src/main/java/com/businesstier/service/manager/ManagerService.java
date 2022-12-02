package com.businesstier.service.manager;

import com.businesstier.model.Manager;
import com.businesstier.network.managerNetwork.ManagerAccount;
import org.springframework.stereotype.Service;

@Service
public class ManagerService implements IManagerService{

    private ManagerAccount managerAccount;

    public ManagerService(ManagerAccount managerAccount){
        this.managerAccount=managerAccount;
    }

    @Override
    public String CreateManagerAccount(Manager manager) {
        return managerAccount.CreateManagerAccount(manager);
    }

    @Override
    public Manager GetManager(String username, String password) {
        return managerAccount.GetManager(username, password);
    }

    @Override
    public void DeleteManager(int id) {
        managerAccount.DeleteManager(id);
    }

    @Override
    public Manager GetManagerByUsername(String username) {
        return managerAccount.GetManagerByUsername(username);
    }

    @Override
    public Manager GetManagerById(int id) {
        return managerAccount.GetManagerById(id);
    }
}
