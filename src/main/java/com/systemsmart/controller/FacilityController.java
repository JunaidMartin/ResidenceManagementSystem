package com.systemsmart.controller;
/*@ Author: Luzuko Tshaka  <216007542@mycput.ac.za>
  @ description : Domain Driven Design - Facility  controllers
*/

import com.systemsmart.entity.Facility;
import com.systemsmart.factory.FacilityFactory;
import com.systemsmart.service.impl.FacilityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/facility")
@CrossOrigin(origins = "http://localhost:6677", allowCredentials = "true")
public class FacilityController {

    @Autowired
    private FacilityServiceImpl facilityService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Facility create (@RequestBody Facility facility){
        Facility newFacility = FacilityFactory.createFacility(facility.getFacilityId(),facility.getLaundromat(),facility.getStudyRoom(),facility.getDisabledFriendly(),facility.getSecurityPersonnel(),facility.getUniversityTransport(),facility.getComputerEquipment(),facility.getWifiAccess(),facility.getElectricitySystem());
        return facilityService.create(newFacility);
    }

    @GetMapping("/all")
    public Set<Facility> getAll(){
        return  facilityService.getAll();
    }

    @GetMapping("/read/{id}")
    public Facility read(@PathVariable String id){
        return facilityService.read(id);
    }

    @PostMapping ("/update")
    public Facility update(@RequestBody Facility  facility){
        return facilityService.update(facility);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return facilityService.delete(id);
    }


}
