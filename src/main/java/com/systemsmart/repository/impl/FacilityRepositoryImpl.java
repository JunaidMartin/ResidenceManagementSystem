package com.systemsmart.repository.impl;

import com.systemsmart.entity.Facility;
import com.systemsmart.repository.FacilityRepository;
import java.util.HashSet;
import java.util.Set;

public class FacilityRepositoryImpl implements FacilityRepository {

  private static FacilityRepository repository = null;
   private Set<Facility> facilityDB;

   FacilityRepositoryImpl(){

      this.facilityDB = new HashSet<>();
   }

        public static FacilityRepository getRepository(){

        if (repository == null)  repository = new FacilityRepositoryImpl();
        return  repository;
    }



    @Override
    public Facility create(Facility facility) {
        this.facilityDB.add(facility);
        return facility;
    }

    @Override
    public Facility read(String facilityId) {
       for (Facility facility : this.facilityDB){

           if (facility.getFacilityID().equalsIgnoreCase(facilityId))
               return facility;
       }
        return null;
    }

    @Override
    public Facility update(Facility facility) {

       boolean deleteFacility = delete(facility.getFacilityID());
               if (deleteFacility){
                   this.facilityDB.add(facility);
                   return facility;
               }

        return null;
    }

    @Override
    public boolean delete(String facilityId) {
       Facility facility = read(facilityId);
       if (facility != null){
           this.facilityDB.remove(facility);
           return true;
       }
        return false;
    }

    @Override
    public Set<Facility> getAll() {
        return this.facilityDB;
    }



}
