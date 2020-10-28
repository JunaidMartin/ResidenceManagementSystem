package com.systemsmart.service.impl;

import com.systemsmart.entity.Residence;
import com.systemsmart.repository.ResidenceRepository;
import com.systemsmart.service.ResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Description: This class implements the Residence Service
    Date: 5 September 2020
 */
@Service
public class ResidenceServiceImpl implements ResidenceService {

    @Autowired
    private ResidenceRepository residenceRepository = null;

    @Override
    public Residence create(Residence residence) {
        return this.residenceRepository.save(residence);
    }

    @Override
    public Residence read(Integer residenceId) {
        return residenceRepository.findById(residenceId).orElseGet(null);
    }

    @Override
    public Residence update(Residence residence) {
        return this.residenceRepository.save(residence);
    }

    @Override
    public boolean delete(Integer residenceId) {
        residenceRepository.deleteById(residenceId);
        return !residenceRepository.existsById(residenceId);
    }

    @Override
    public Set<Residence> getAll() {
        return new HashSet<>(this.residenceRepository.findAll());
    }
}
