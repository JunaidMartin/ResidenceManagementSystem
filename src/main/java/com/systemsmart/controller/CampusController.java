package com.systemsmart.controller;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 25/09/2020*/

import com.systemsmart.entity.Campus;
import com.systemsmart.factory.CampusFactory;
import com.systemsmart.service.impl.CampusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/campus")
@CrossOrigin(origins = "http://localhost:6677", allowCredentials = "true")
public class CampusController {

    @Autowired
    private CampusServiceImpl campusService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Campus create(@RequestBody Campus campus){
        Campus newCampus = CampusFactory.createCampus(campus.getCampusId(), campus.getName());
        return campusService.create(newCampus);
    }

    @GetMapping("/read/{id}")
    public Campus read(@PathVariable int id){
        return campusService.read(id);
    }

    @PostMapping ("/update")
    public Campus update(@RequestBody Campus student){
        return campusService.update(student);
    }

    @GetMapping("/all")
    public Set<Campus> getall(){
        return campusService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id){
        return campusService.delete(id);
    }
}

