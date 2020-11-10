package com.systemsmart.controller;

import com.systemsmart.entity.Complaint;
import com.systemsmart.factory.ComplaintFactory;
import com.systemsmart.service.impl.ComplaintServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/complaint")
@CrossOrigin(origins = "http://localhost:6677", allowCredentials = "true")
public class ComplaintController {

    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Date: 23 September 2020
     */
    @Autowired
    private ComplaintServiceImpl service;

    //create
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Complaint create(@RequestBody Complaint c){
        Complaint complaint = ComplaintFactory.logComplaint(c.getComplaintID(), c.getDescription(), c.getLogStatus());
        return service.create(complaint);
    }

    //read
    @GetMapping("/read/{id}")
    public Complaint read(@PathVariable String id){
        return service.read(id);
    }

    //update
    @PostMapping ("/update")
    public Complaint update(@RequestBody Complaint complaint){
        return service.update(complaint);
    }

    //getAll
    @GetMapping("/all")
    public Set<Complaint> getall(){
        return service.retrieve();
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }
}
