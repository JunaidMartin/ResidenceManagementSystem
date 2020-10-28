//package com.systemsmart.service.impl;
///*Author: @Phumelela Hoho
//* <212195131@mycput.ac.za>
//Description: Domain class description
//* Date: 05/07/2020*/
//
//import com.systemsmart.entity.Campus;
//import com.systemsmart.factory.CampusFactory;
//import com.systemsmart.service.CampusService;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class CampusServiceImplTest {
//
//    private static CampusService service = CampusServiceImpl.getService();
//    private static Campus campus = CampusFactory.createCampus(216178606, "CPUT District Six Campus");
//
//    @Test
//    public void d_getAll() {
//        Set<Campus> campuses = service.getAll();
//        assertEquals(1, campuses.size());
//        System.out.println("All campuses: " + campuses);
//    }
//
//    @Test
//    public void a_create() {
//        Campus created = service.create(campus);
//        Assert.assertEquals(campus.getCampusId(), created.getCampusId());
//        System.out.println ("Created: " + created);
//    }
//
//    @Test
//    public void b_read() {
//        Campus read = service.read(campus.toString());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update() {
//        Campus updated = new Campus.Builder().copy(campus).setName("Phumelela").build();
//        updated = service.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void f_delete() {
//       boolean deleted = service.delete(campus.toString());
//
//        Assert.assertTrue(deleted);
//
//    }
//
//    @Test
//    public void e_getCampusesWithCampusID217() {
//    }
//}