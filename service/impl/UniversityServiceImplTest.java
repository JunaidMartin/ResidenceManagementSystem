//package com.systemsmart.service.impl;
///*Author: @Phumelela Hoho
//* <212195131@mycput.ac.za>
//Description: Domain class description
//* Date: 05/07/2020*/
//
//import com.systemsmart.entity.University;
//import com.systemsmart.factory.UniversityFactory;
//import com.systemsmart.service.UniversityService;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
//public class UniversityServiceImplTest {
//    private static UniversityService service = UniversityServiceImpl.getService();
//    private static University university = UniversityFactory.createUniversity("CPUT");
//
//    @Test
//    public void d_getAll() {
//        Set<University> universities = service.getAll();
//        assertEquals(1, universities.size());
//        System.out.println("All universities: " + universities);
//    }
//
//    @Test
//    public void a_create() {
//        University created = service.create(university);
//        Assert.assertEquals(university.getUniversityName(), created.getUniversityName());
//        System.out.println ("Created: " + created);
//    }
//
//    @Test
//    public void b_read() {
//        University read = service.read(university.getUniversityName());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update() {
//        University updated = new University.Builder().copy(university).setUniversityName("Phumelela").build();
//        updated = service.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void f_delete() {
//        boolean deleted = service.delete(university.getUniversityName());
//        Assert.assertTrue(deleted);
//    }
//
//    @Test
//    public void e_getUniversityWithUniversityNameCPUT() {
//    }
//}