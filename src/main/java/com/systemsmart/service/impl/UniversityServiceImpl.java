package com.systemsmart.service.impl;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 05/07/2020*/

import com.systemsmart.entity.University;
import com.systemsmart.repository.UniversityRepository;
//import com.systemsmart.repository.impl.UniversityRepositoryImpl;
import com.systemsmart.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    //private static UniversityService service = null;
    private UniversityRepository repository;

  //  private UniversityServiceImpl(){
  //      this.repository = UniversityRepositoryImpl.getRepository();
    //}

    //public static UniversityService getService(){
      //  if (service == null) service = new UniversityServiceImpl();
        //return service;
    //}

    @Override
    public Set<University> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

   // @Override
  //  public Set<University> getUniversityWithUniversityNameCPUT() {
   //     Set<University> universities = getAll();
   //     Set<University> universitiesWithCPUT = new HashSet<>();
    //    for (University university : universities) {
    //        if (university.getUniversityName().trim().startsWith("CPUT")){
     //           universitiesWithCPUT.add(university);
     //       }
    //    }
    //    return universitiesWithCPUT;
   // }

    @Override
    public University create(University university) {
        return this.repository.save(university);
    }

    @Override
    public University read(String u) {
        return this.repository.findById(u).orElseGet(null);
    }

    @Override
    public University update(University university) {
        if (this.repository.existsById(university.getUniversityName())){
            return this.repository.save(university);
        }
        return null;
    }

    @Override
    public boolean delete(String u) {
        this.repository.deleteById(u);
        if(this.repository.existsById(u)) return false;
        return true;
    }
}
