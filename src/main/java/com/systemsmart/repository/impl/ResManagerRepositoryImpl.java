//package com.systemsmart.repository.impl;
//
//import com.systemsmart.entity.ResidenceManager;
//import com.systemsmart.repository.ResManagerRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class ResManagerRepositoryImpl implements ResManagerRepository {
//    private Set<ResidenceManager> resManSet;
//
//    public ResManagerRepositoryImpl() {
//        this.resManSet = new HashSet<>();
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
//        this.resManSet.add(residenceManager);
//        return residenceManager;
//    }
//
//
//    @Override
//    public ResidenceManager read(Integer employeeId){
//        for(ResidenceManager rs : this.resManSet)
//            if(rs.getEmployeeId() == (employeeId)) return rs;
//
//
//        return null;
//    }
//
//    @Override
//    public boolean delete(Integer employeeId){
//        ResidenceManager resMan = read(employeeId);
//        if(resMan != null){
//            resManSet.remove(resMan);
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public ResidenceManager update(ResidenceManager residenceManager) {
//        boolean resMan = delete(residenceManager.getEmployeeId());
//            if(resMan){
//                resManSet.add(residenceManager);
//                return residenceManager;
//        }
//        return null;
//    }
//
//    @Override
//    public Set<ResidenceManager> retrieve() {
//        return this.resManSet;
//    }
//}
