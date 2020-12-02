package com.systemsmart.service;

import com.systemsmart.entity.Student;
import com.systemsmart.entity.StudentApplication;
import com.systemsmart.service.impl.StudentApplicationServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Set;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Date:  13 November 2020
 */

public interface StudentApplicationService extends IService<StudentApplication, String>{
    Set<StudentApplication> getAll(Authentication authentication);
    String createApplication(String studentId, MultipartFile applicationForms, Authentication authentication);
    String getApplication(Authentication authentication);
    StudentApplication getApplicationByStudentNumber(String studentNumber);
    StudentApplication setStatus(String applicationId, String status, Authentication authentication);
}
