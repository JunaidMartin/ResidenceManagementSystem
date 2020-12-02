package com.systemsmart.controller;

import com.systemsmart.entity.StudentApplication;
import com.systemsmart.service.impl.StudentApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Set;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Date:  13 November 2020
 */

@RestController
@RequestMapping("/applications")
public class StudentApplicationController {

    @Autowired
    private StudentApplicationServiceImpl studentApplicationService;

    @PostMapping("/new")
    public String createStudentApplication(@RequestParam("studentId")String studentId, @RequestParam("applicationForms")MultipartFile applicationForms, Authentication authentication){
        return studentApplicationService.createApplication(studentId, applicationForms, authentication);
    }

    @GetMapping("/myapplication")
    public String getStudentApplication(Authentication authentication){
        return studentApplicationService.getApplication(authentication);
    }

    @GetMapping("/all")
    public Set<StudentApplication> getAllStudentApplications(Authentication authentication){
        return studentApplicationService.getAll(authentication);
    }

    @PostMapping("/edit/status/{id}/{status}")
    public StudentApplication setApplicationStatus(@PathVariable String id, @PathVariable String status, Authentication authentication){
        return studentApplicationService.setStatus(id, status, authentication);
    }
    @DeleteMapping("/cancel")
    public boolean cancelApplication(Authentication authentication){
        return studentApplicationService.delete(authentication.getName());
    }
}
