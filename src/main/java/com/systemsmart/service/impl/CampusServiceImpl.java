package com.systemsmart.service.impl;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 05/07/2020*/

import com.systemsmart.entity.Campus;
import com.systemsmart.entity.Student;
import com.systemsmart.repository.CampusRepository;
//import com.systemsmart.repository.impl.CampusRepositoryImpl;
import com.systemsmart.service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CampusServiceImpl implements CampusService {
    @Autowired
    private CampusRepository repository;

   // private CampusServiceImpl(){
   //     this.repository = CampusRepositoryImpl.getRepository();
    //}

 //   public static CampusService getService(){
   //     if (service == null) service = new CampusServiceImpl();
     //   return service;
   // }

    @Override
    public Set<Campus> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


   // @Override
   // public Set<Campus> getCampusesWithCampusID217() {
   //     Set<Campus> campuses = getAll();
    //    Set<Campus> campusWith217 = new HashSet<>();
    //    for (Campus campus : campuses) {
     //       if (campus.getCampusId() == 217){
     //           campusWith217.add(campus);
     //       }
     //   }
    //    return campusWith217;
   // }

    @Override
    public Campus create(Campus campus) {
        return this.repository.save(campus);
    }

    @Override
    public Campus read(String c) {
        return this.repository.findById(c).orElseGet(null);
    }

    @Override
    public Campus update(Campus campus) {
        if (this.repository.existsById(campus.toString())){
            return this.repository.save(campus);
        }
        return null;
    }

    @Override
    public boolean delete(String c) {
        this.repository.deleteById(c);
        if(this.repository.existsById(c)) return false;
        return true;
    }
}
