package com.systemsmart.controller;

import com.systemsmart.entity.Residence;
import com.systemsmart.factory.ResidenceFactory;
import com.systemsmart.service.impl.ResidenceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Description: Residence controller for handling requests
    Date:  26 September 2020
 */

@RestController
@RequestMapping("/residence")
public class ResidenceController {

    @Autowired
    private ResidenceServiceImpl residenceService;

    @PostMapping("/create")
    public Residence createResidence(@RequestBody Residence residence){
        Residence newRes = ResidenceFactory.createResidence(residence.getResidenceId(), residence.getRoomsAvailable(), residence.getResidenceName());
        return residenceService.create(newRes);
    }
    @PostMapping("/update")
    public Residence updateResidence(@RequestBody Residence residence){
        return residenceService.update(residence);
    }
    @GetMapping("/{id}")
    public Residence getResidence(@PathVariable int id){
        return residenceService.read(id);
    }
    @GetMapping("/all")
    public Set<Residence> getAllResidences(){
        return residenceService.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public  boolean delete(@PathVariable int id){
        return residenceService.delete(id);
    }
}
