package com.systemsmart.repository.impl;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 28/08/2020*/
import com.systemsmart.entity.Campus;
import com.systemsmart.entity.Student;
import com.systemsmart.factory.CampusFactory;
import com.systemsmart.factory.StudentFactory;
import com.systemsmart.repository.CampusRepository;
import com.systemsmart.repository.StudentRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CampusRepositoryImplTest {
    private static CampusRepository repository = CampusRepositoryImpl.getRepository();
    private static Campus campus = CampusFactory.createCampus(216178606, "CPUT District Six Campus");


    @Test
    public void a_create() {
        Campus created = repository.create(campus);
        Assert.assertEquals(campus.getCampusId(), created.getCampusId());
        System.out.println ("Created: " + created);
    }

    @Test
    public void b_read() {
        Campus read = repository.read(campus.getName());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Campus updated = new Campus.Builder().copy(campus).setName("Phumelela").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(campus.getName());
        Assert.assertTrue(deleted);
    }

    @Test
    public void d_getAll() {
        System.out.println("Get all: " + repository.getAll());
    }
}