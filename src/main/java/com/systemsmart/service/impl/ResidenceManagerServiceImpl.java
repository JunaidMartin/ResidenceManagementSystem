package com.systemsmart.service.impl;
import com.systemsmart.entity.ResidenceManager;
import com.systemsmart.repository.ResManagerRepository;
import com.systemsmart.repository.impl.ResManagerRepositoryImpl;
import com.systemsmart.service.ResidenceManagerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ResidenceManagerServiceImpl implements ResidenceManagerService {

    // Christ Kitenge Mbuyi <217249756@mycput.ac.za>

    private static ResidenceManagerService service = null;
    private ResManagerRepository repository;

    private ResidenceManagerServiceImpl(){

        this.repository = ResManagerRepositoryImpl.getRepository();
    }

    public static ResidenceManagerService getService(){
        if (service == null) service = new ResidenceManagerServiceImpl();
        return service;
    }

    @Override
    public ResidenceManager create(ResidenceManager rs) {
        return this.repository.create(rs);
    }

    @Override
    public ResidenceManager read(String s) {
        return this.repository.read(s);
    }

    @Override
    public ResidenceManager update(ResidenceManager rs) {
        return this.repository.update(rs);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }


    @Override
    public Set<ResidenceManager> retrieve() {
        return this.repository.retrieve();
    }
}


