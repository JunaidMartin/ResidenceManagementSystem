//package com.systemsmart.repository.impl;
//
//import com.systemsmart.entity.ResidenceManager;
//import com.systemsmart.factory.ResManagerFactory;
//import com.systemsmart.repository.ResManagerRepository;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class ResManagerRepositoryImplTest {
//
//    private static ResManagerRepository repository = ResManagerRepositoryImpl.getRepository();
//
//    private static ResidenceManager rm = ResManagerFactory.resMan(217248756, "Joel", "Kutino", "10 Feb 2013", "Bellville", 7);
//
//
//    @Test
//    public void create() {
//        ResidenceManager manager = repository.create(rm);
//        Assert.assertEquals(rm.getEmployeeId(), manager.getEmployeeId());
//        System.out.println ("Created: " + manager);
//    }
//
//    @Test
//    public void read() {
//        ResidenceManager read = repository.read(rm.getFirstName());
//    }
//
//    @Test
//    public void c_update() {
//        ResidenceManager updated = new ResidenceManager.Builder().copy(rm).setLastName("Jessy").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//
//    }
//
//    @Test
//    public void e_delete() {
//        boolean deleted = repository.delete(rm.getFirstName());
//        Assert.assertTrue(deleted);
//
//    }
//
//    @Test
//    public void retrieve() {
//        System.out.println("Get all: " + repository.retrieve());
//    }
//}
//
//
//
//
