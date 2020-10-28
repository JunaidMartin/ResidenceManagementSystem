package com.systemsmart.service.impl;

import com.systemsmart.entity.Facility;
import com.systemsmart.repository.FacilityRepository;
import com.systemsmart.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
/*@ Author: Luzuko Tshaka  <216007542@mycput.ac.za>
  @ description : Domain Driven Design - Facility serviceImpl
*/

@Service
public class FacilityServiceImpl implements FacilityService {

    private static FacilityService service = null;

    @Autowired
    private FacilityRepository repository;

//    private FacilityServiceImpl(){
//        this.repository = FacilityRepositoryImpl.getFacilityRepository();
//    }
//
//    public static FacilityService getService(){
//        if (service == null) service = new FacilityServiceImpl();
//        return service;
//    }


    @Override
    public Set<Facility> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Facility create(Facility t) {
        return this.repository.save(t);
    }

    @Override
    public Facility read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Facility update(Facility t) {

        if (this.repository.existsById(t.getFacilityId())){
        return this.repository.save(t);
        }

        return null;
    }

    @Override
    public boolean delete(String s) {
         this.repository.deleteById(s);

        return !this.repository.existsById(s);
    }
}
