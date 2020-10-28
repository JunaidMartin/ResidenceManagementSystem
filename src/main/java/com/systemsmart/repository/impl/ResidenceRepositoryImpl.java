//DEPRECATED
//package com.systemsmart.repository.impl;
//
//import com.systemsmart.entity.Residence;
//import com.systemsmart.repository.ResidenceRepository;
//import java.util.HashSet;
//import java.util.Set;
//
//public class ResidenceRepositoryImpl implements ResidenceRepository  {
//
//    private static ResidenceRepository repository = null;
//    private Set<Residence> residenceDB;
//
//    private ResidenceRepositoryImpl() {
//        this.residenceDB = new HashSet<>();
//    }
//
//    public static ResidenceRepository getRepository(){
//        if (repository == null) repository =  new ResidenceRepositoryImpl();
//        return repository;
//    }
//
//    @Override
//    public Residence create(Residence residence) {
//        residenceDB.add(residence);
//        return residence;
//    }
//
//    @Override
//    public Residence read(Integer residenceID) {
//        for (Residence res: residenceDB)
//            if(res.getResidenceId() == residenceID) return res;
//
//        return null;
//    }
//
//    @Override
//    public Residence update(Residence residence) {
//        boolean resRemoved = delete(residence.getResidenceId());
//        if(resRemoved){
//            residenceDB.add(residence);
//            return residence;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(Integer residenceID) {
//        Residence res = read(residenceID);
//        if(res != null){
//            residenceDB.remove(res);
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public Set<Residence> getAll() {
//        return residenceDB;
//    }
//}
