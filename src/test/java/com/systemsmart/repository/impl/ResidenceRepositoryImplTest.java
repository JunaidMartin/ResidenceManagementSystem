package com.systemsmart.repository.impl;

import com.systemsmart.entity.Residence;
import com.systemsmart.factory.ResidenceFactory;
import com.systemsmart.repository.ResidenceRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResidenceRepositoryImplTest {
    private static ResidenceRepository repository = ResidenceRepositoryImpl.getRepository();
    private static Residence residence = ResidenceFactory.createResidence(223, 12, "Test Residence");

    @Test
    public void a_create() {
        Residence addedRes = repository.create(residence);
        Assert.assertEquals(residence.getResidenceId(), addedRes.getResidenceId());
        System.out.println ("Create: " + addedRes);
    }

    @Test
    public void b_read() {
        Residence read = repository.read(residence.getResidenceId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Residence update = new Residence.Builder().copy(residence).setName("Updated Test Residence").build();
        update = repository.update(update);
        System.out.println("Updated: " + update);
    }

    @Test
    public void d_getAll() {
        System.out.println("Get all: " + repository.getAll());
    }

    @Test
    public void e_delete() {
        boolean isDeleted = repository.delete(residence.getResidenceId());
        Assert.assertTrue(isDeleted);
    }
}