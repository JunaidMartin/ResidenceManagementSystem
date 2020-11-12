package com.systemsmart.service.impl;
import com.systemsmart.entity.ResidenceManager;
import com.systemsmart.repository.ResManagerRepository;
import com.systemsmart.service.ResidenceManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ResidenceManagerServiceImpl implements ResidenceManagerService {

    // Christ Kitenge Mbuyi <217248756@mycput.ac.za>

    @Autowired
    private ResManagerRepository repository;


    @Override
    public ResidenceManager create(ResidenceManager rs) {
        return this.repository.save(rs);
    }

    @Override
    public ResidenceManager read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public ResidenceManager update(ResidenceManager rs) {
        if(this.repository.existsById(rs.getLastName())){
            return this.repository.save(rs);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s)) return false;
        else return true;
    }


    @Override
    public Set<ResidenceManager> retrieve() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    //  @Override
//    public Set<ResidenceManager> getManagerSurname() {
//        Set<ResidenceManager> residenceManager = retrieve();
//        Set<ResidenceManager> managerSurname = new HashSet<>();
//        for (ResidenceManager rm : complaints) {
//            if (rm.getLogStatus().trim().startsWith("K")){
//                processingComplaint.add(rm);
//            }
//        }
//        return managerSurname;
//    }
}


