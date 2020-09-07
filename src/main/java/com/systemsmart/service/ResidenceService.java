package com.systemsmart.service;

import com.systemsmart.entity.Residence;

import java.util.Set;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Description: Residence service interface which extends IService in order to add getAll() and leave room for future methods
    Date:  5 September 2020
 */
public interface ResidenceService extends IService<Residence, Integer, A> {

    Set<Residence> getAll();
}
