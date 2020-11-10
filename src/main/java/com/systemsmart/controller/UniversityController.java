package com.systemsmart.controller;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 25/09/2020*/

import com.systemsmart.entity.Student;
import com.systemsmart.entity.University;
import com.systemsmart.factory.StudentFactory;
import com.systemsmart.factory.UniversityFactory;
import com.systemsmart.service.impl.UniversityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/university")
@CrossOrigin(origins = "http://localhost:6677", allowCredentials = "true")
public class UniversityController {

    @Autowired
    private UniversityServiceImpl universityService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public University create(@RequestBody University university){
        University newUniversity = UniversityFactory.createUniversity(university.getUniversityId(), university.getUniversityName());
        return universityService.create(newUniversity);
    }

    @GetMapping("/read/{id}")
    public University read(@PathVariable int id){
        return universityService.read(id);
    }

    @PostMapping ("/update")
    public University update(@RequestBody University university){
        return universityService.update(university);
    }

    @GetMapping("/all")
    public Set<University> getall(){
        return universityService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id){
        return universityService.delete(id);
    }
}
