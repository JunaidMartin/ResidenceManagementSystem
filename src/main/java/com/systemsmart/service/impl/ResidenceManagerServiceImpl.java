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

    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Description: This class implements the Residence Manager service interface methods
     * Date: 03 September 2020
     */

    @Autowired
    private ResManagerRepository repository;


    @Override
    public ResidenceManager create(ResidenceManager rs) {
        return this.repository.save(rs);
    }

    @Override
    public ResidenceManager read(Integer employeeId) {
        return this.repository.findById(employeeId).orElseGet(null);
    }

    @Override
    public ResidenceManager update(ResidenceManager rs) {
        if(this.repository.existsById(rs.getEmployeeId())){
            return this.repository.save(rs);
        }
        return null;
    }

    @Override
    public boolean delete(Integer employeeId) {
        repository.deleteById(employeeId);
        return !repository.existsById(employeeId);
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


