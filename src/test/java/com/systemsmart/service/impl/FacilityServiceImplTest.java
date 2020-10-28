//package com.systemsmart.service.impl;
//
//import com.systemsmart.entity.Facility;
//import com.systemsmart.entity.Student;
//import com.systemsmart.factory.FacilityFactory;
//import com.systemsmart.factory.StudentFactory;
//import com.systemsmart.service.FacilityService;
//import com.systemsmart.service.StudentService;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
///*@ Author: Luzuko Tshaka  <216007542@mycput.ac.za>
//  @ description : Domain Driven Design - Facility serviceImpl test
//*/
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class FacilityServiceImplTest {
//
//    private static FacilityService service = FacilityServiceImpl.getService();
//    private static Facility facility = FacilityFactory.createFacility("234555",true,true,true,
//            true,true,true,true,"pre-paid electricity meter");;
//
//
//
//    @Test
//    public void d_getAll() {
//        Set<Facility> facility = service.getAll();
//        assertEquals(1, facility.size());
//        System.out.println("Facility details " + facility);
//
//    }
//
//    @Test
//    public void a_create() {
//        Facility create = service.create(facility);
//        Assert.assertEquals(facility.getFacilityId(),create.getFacilityId());
//        System.out.println("create: "+ create);
//}
//
//    @Test
//    public void b_read() {
//
//        Facility read = service.read(facility.getFacilityId());
//        System.out.println("Read: "+ read);
//    }
//
//    @Test
//    public void c_update() {
//        Facility update = new Facility.Builder().copy(facility).setDisabledFriendly(false).build();
//        update = service.update(update);
//        System.out.println("update: "+ update);
//    }
//
//    @Test
//    public void f_delete() {
//        boolean deleted = service.delete(facility.getFacilityId());
//        Assert.assertTrue(deleted);
//    }
//
//}