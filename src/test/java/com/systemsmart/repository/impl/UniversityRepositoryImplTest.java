//package com.systemsmart.repository.impl;
///*Author: @Phumelela Hoho
//* <212195131@mycput.ac.za>
//Description: Domain class description
//* Date: 28/08/2020*/
//
//import com.systemsmart.entity.University;
//import com.systemsmart.factory.UniversityFactory;
//import com.systemsmart.repository.UniversityRepository;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class UniversityRepositoryImplTest {
//        private static UniversityRepository repository = UniversityRepositoryImpl.getRepository();
//        private static University university = UniversityFactory.createUniversity("CPUT");
//
//
//        @Test
//        public void a_create() {
//            University created = repository.create(university);
//            Assert.assertEquals(university.getUniversityName(), created.getUniversityName());
//            System.out.println("Created: " + created);
//        }
//
//        @Test
//        public void b_read() {
//            University read = repository.read(university.getUniversityName());
//            System.out.println("Read: " + read);
//        }
//
//        @Test
//        public void c_update() {
//            University updated = new University.Builder().copy(university).setUniversityName("CPUT").build();
//            updated = repository.update(updated);
//            System.out.println("Updated: " + updated);
//        }
//
//        @Test
//        public void e_delete() {
//            boolean deleted = repository.delete(university.getUniversityName());
//            Assert.assertTrue(deleted);
//        }
//
//        @Test
//        public void d_getAll() {
//            System.out.println("Get all: " + repository.getAll());
//        }
//    }
