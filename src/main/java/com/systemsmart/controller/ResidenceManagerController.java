package com.systemsmart.controller;

import com.systemsmart.entity.ResidenceManager;
import com.systemsmart.factory.ResManagerFactory;
import com.systemsmart.service.impl.ResidenceManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/manager")
public class ResidenceManagerController {

    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Date: 23 September 2020
     */

    @Autowired
    private ResidenceManagerServiceImpl service;

    //create
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResidenceManager create(@RequestBody ResidenceManager rm){
        ResidenceManager residenceManager = ResManagerFactory.resMan(rm.getEmployeeId(), rm.getFirstName(), rm.getLastName(), rm.getEmploymentDate(), rm.getResidenceName(), rm.getAccessLevel());
        return service.create(residenceManager);
    }

    //read
    @GetMapping("/read/{id}")
    public ResidenceManager read(@PathVariable int id){
        return service.read(id);
    }

    //update
    @PostMapping ("/update")
    public ResidenceManager update(@RequestBody ResidenceManager residenceManager){
        return service.update(residenceManager);
    }

    //getAll
    @GetMapping("/all")
    public Set<ResidenceManager> getall(){
        return service.retrieve();
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id){
        return service.delete(id);
    }
}
