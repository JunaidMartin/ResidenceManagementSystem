package com.systemsmart.controller;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Date:  13 November 2020
 */

import com.systemsmart.entity.StudentApplication;
import com.systemsmart.service.impl.StudentApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/applications")
public class StudentApplicationController {

    @Autowired
    private StudentApplicationServiceImpl studentApplicationService;

    @GetMapping("/{id}")
    public StudentApplication getStudentApplication(@PathVariable int id){
        return studentApplicationService.read(id);
    }

    @GetMapping("/all")
    public Set<StudentApplication> getAllStudentApplications(){
        return studentApplicationService.getAll();
    }
}
