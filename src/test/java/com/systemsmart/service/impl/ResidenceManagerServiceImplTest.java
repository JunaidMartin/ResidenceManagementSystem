//package com.systemsmart.service.impl;
//
//import com.systemsmart.entity.ResidenceManager;
//import com.systemsmart.factory.ResManagerFactory;
//import com.systemsmart.service.ResidenceManagerService;
//import org.junit.Assert;
//import org.junit.Test;
//
//
//public class ResidenceManagerServiceImplTest {
//
//    /*
//     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
//     * Description: This class tests the Residence Manager service interface methods
//     * Date: 03 September 2020
//     */
//
//    private ResidenceManagerService service;
//
//    private static ResidenceManager rm = ResManagerFactory.resMan(217248756, "Joel", "Kutino", "10 Feb 2013", "Bellville", 7);
//
//    @Test
//    public void create() {
//        ResidenceManager manager = service.create(rm);
//        Assert.assertEquals(rm.getEmployeeId(), manager.getEmployeeId());
//        System.out.println ("Created: " + manager);
//    }
//
//    @Test
//    public void read() {
//        ResidenceManager read = service.read(rm.getFirstName());
//        System.out.println(read);
//    }
//
//    @Test
//    public void c_update() {
//        ResidenceManager updated = new ResidenceManager.Builder().copy(rm).setLastName("Jessy").build();
//        updated = service.update(updated);
//        System.out.println("Updated: " + updated);
//
//    }
//
//    @Test
//    public void e_delete() {
//        boolean deleted = service.delete(rm.getFirstName());
//        Assert.assertTrue(deleted);
//        //deleted = service.delete(deleted);
//        System.out.println("Deleted: " + deleted);
//
//    }
//
//    @Test
//    public void retrieve() {
//        System.out.println("Get all: " + service.retrieve());
//    }
//}
