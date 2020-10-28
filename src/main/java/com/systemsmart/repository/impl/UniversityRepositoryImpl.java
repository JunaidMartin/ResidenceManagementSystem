//package com.systemsmart.repository.impl;
///*Author: @Phumelela Hoho
//* <212195131@mycput.ac.za>
//Description: Domain class description
//* Date: 28/08/2020*/
//
//import com.systemsmart.entity.Student;
//import com.systemsmart.entity.University;
//import com.systemsmart.repository.CampusRepository;
//import com.systemsmart.repository.StudentRepository;
//import com.systemsmart.repository.UniversityRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class UniversityRepositoryImpl implements UniversityRepository {
//
//        private static UniversityRepository repository = null;
//        private Set<University> universityDB;
//
//    private UniversityRepositoryImpl() {this.universityDB = new HashSet<>();}
//
//        public static UniversityRepository getRepository(){
//        if (repository == null) repository =  new UniversityRepositoryImpl();
//        return repository;
//    }
//
//
//        public University create(University university) {
//        this.universityDB.add(university);
//        return university;
//    }
//
//
//        public University read(String universityName) {
////        University university = this.universityDB.stream().filter(s -> s.getUniversityName().trim().equalsIgnoreCase(universityName)).findAny().orElse(null);
//
//        for (University university : this.universityDB){
//            if (university.getUniversityName().equalsIgnoreCase(universityName)) return university;
//        }
//        return null;
//    }
//
//
//        public University update(University university) {
//        boolean deleteUniversity = delete(university.getUniversityName());
//        if (deleteUniversity){
//            this.universityDB.add(university);
//            return university;
//        }
//        return null;
//    }
//
//
//        public boolean delete(String universityName) {
//        University university = read(universityName);
//        if (university != null){
//            this.universityDB.remove(university);
//            return true;
//        }
//        return false;
//    }
//
//
//        public Set<University> getAll() {
//        return this.universityDB;
//    }
//    }
