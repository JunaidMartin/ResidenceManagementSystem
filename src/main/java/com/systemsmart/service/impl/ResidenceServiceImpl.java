package com.systemsmart.service.impl;

import com.systemsmart.entity.Residence;
import com.systemsmart.repository.ResidenceRepository;
import com.systemsmart.repository.impl.ResidenceRepositoryImpl;
import com.systemsmart.service.ResidenceService;
import org.springframework.stereotype.Service;

import java.util.Set;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Description: This class implements the Residence Service
    Date: 5 September 2020
 */
@Service
public class ResidenceServiceImpl implements ResidenceService {

    private static ResidenceService residenceService = null;
    private ResidenceRepository residenceRepository = null;

    private  ResidenceServiceImpl(){
        residenceRepository = ResidenceRepositoryImpl.getRepository();
    }

    public static ResidenceService getService(){
        if(residenceService == null) residenceService = new ResidenceServiceImpl();
        return residenceService;
    }

    @Override
    public Residence create(Residence residence) {
        return residenceRepository.create(residence);
    }

    @Override
    public Residence read(Integer residenceId) {
        return residenceRepository.read(residenceId);
    }

    @Override
    public Residence update(Residence residence) {
        return residenceRepository.update(residence);
    }

    @Override
    public boolean delete(Integer residenceId) {
        return residenceRepository.delete(residenceId);
    }

    @Override
    public Set<Residence> getAll() {
        return residenceRepository.getAll();
    }
}
