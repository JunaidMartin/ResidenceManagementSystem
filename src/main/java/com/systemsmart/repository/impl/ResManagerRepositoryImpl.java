//package com.systemsmart.repository.impl;
//
//import com.systemsmart.entity.ResidenceManager;
//import com.systemsmart.repository.ResManagerRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class ResManagerRepositoryImpl implements ResManagerRepository {
//    private Set<ResidenceManager> ResManSet;
//
//    public ResManagerRepositoryImpl() {
//        this.ResManSet = new HashSet<>();
//    }
//
//    private static ResManagerRepository repository = null;
//
//
//
//    public static ResManagerRepository getRepository(){
//        if (repository == null) repository = new ResManagerRepositoryImpl();
//        return repository;
//    }
//
//    @Override
//    public ResidenceManager create(ResidenceManager residenceManager) {
//        this.ResManSet.add(residenceManager);
//        return residenceManager;
//    }
//
//
//    @Override
//    public ResidenceManager read(String firstName){
//        for(ResidenceManager rs : this.ResManSet){
//            if(rs.getFirstName().equalsIgnoreCase(firstName)){
//                return rs;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String lastName){
//        ResidenceManager rs = read(lastName);
//        if(rs != null) this.ResManSet.remove(rs);
//        return true;
//    }
//
//    @Override
//    public ResidenceManager update(ResidenceManager residenceManager) {
//        ResidenceManager rs = read(residenceManager.getFirstName());
//        if (rs != null) {
//            this.ResManSet.remove(rs);
//            this.ResManSet.add(residenceManager);
//        }
//        return residenceManager;
//    }
//
//    @Override
//    public Set<ResidenceManager> retrieve() {
//        return this.ResManSet;
//    }
//}
