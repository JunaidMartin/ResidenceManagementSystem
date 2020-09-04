package com.systemsmart.service.impl;

import com.systemsmart.entity.Facility;
import com.systemsmart.repository.FacilityRepository;
import com.systemsmart.repository.impl.FacilityRepositoryImpl;
import com.systemsmart.service.FacilityService;

import java.util.HashSet;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService {

    private static FacilityService service = null;
    private FacilityRepository repository;

    private FacilityServiceImpl(){
        this.repository = FacilityRepositoryImpl.getRepository();
    }
    public static FacilityService getService(){
        if (service == null) service = new FacilityServiceImpl();
        return service;
    }


    @Override
    public Set<Facility> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Facility create(Facility t) {
        return this.repository.create(t);
    }

    @Override
    public Facility read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Facility update(Facility t) {
        return this.repository.update(t);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
