package com.systemsmart.service.impl;

import com.systemsmart.entity.Residence;
import com.systemsmart.factory.ResidenceFactory;
import com.systemsmart.service.ResidenceService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Description: Test class for ResidenceServiceImpl
    Date: 5 September 2020
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResidenceServiceImplTest {

    private static ResidenceService residenceService = ResidenceServiceImpl.getService();
    private static Residence residence = ResidenceFactory.createResidence(121,3,"Test Res");

    @Test
    public void a_create() {
        Residence res = residenceService.create(residence);
        Assert.assertEquals(residence.getResidenceId(),res.getResidenceId());
        System.out.println("Created: " + res);
    }

    @Test
    public void b_read() {
        Residence res = residenceService.read(residence.getResidenceId());
        System.out.println("Read: " + res);
    }

    @Test
    public void c_update() {
        Residence res = new Residence.Builder().copy(residence).setName("Updated Res").build();
        res = residenceService.update(res);
        System.out.println("Updated: " + res);
    }

    @Test
    public void d_getAll() {
        Set<Residence> residences = residenceService.getAll();
        Assert.assertEquals(1, residences.size());
        System.out.println("Retrieved all: " + residences);
    }

    @Test
    public void e_delete() {
        boolean isDeleted = residenceService.delete(residence.getResidenceId());
        Assert.assertTrue(isDeleted);
    }
}