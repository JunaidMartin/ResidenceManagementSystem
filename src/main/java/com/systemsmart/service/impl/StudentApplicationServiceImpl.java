package com.systemsmart.service.impl;

import com.systemsmart.entity.StudentApplication;
import com.systemsmart.factory.StudentApplicationFactory;
import com.systemsmart.repository.StudentApplicationRepository;
import com.systemsmart.service.StudentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Date:  13 November 2020
 */

@Service
public class StudentApplicationServiceImpl implements StudentApplicationService {

    @Autowired
    private StudentApplicationRepository repository = null;

    @Override
    public StudentApplication create(StudentApplication t) {
        return this.repository.save(t);
    }

    @Override
    public StudentApplication read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public StudentApplication update(StudentApplication t) {
        return this.repository.save(t);
    }

    @Override
    public boolean delete(String s) {
        repository.deleteById(s);
        return !repository.existsById(s);
    }

    @Override
    public String createApplication(String studentId, MultipartFile applicationForms, Authentication authentication) {
        Response response = new Response();

        if(!authentication.isAuthenticated())  {
            response.isSuccessful = false;
            response.message ="NOT_AUTHENTICATED";
            return response.toString();
        }
        if(read(authentication.getName()) != null) {
            response.isSuccessful = false;
            response.message ="APPLICATION_ALREADY_EXISTS";
            return response.toString();
        }
        if(getApplicationByStudentNumber(studentId) != null) {
            response.isSuccessful = false;
            response.message ="APPLICATION_ALREADY_EXISTS";
            return response.toString();
        }
        try{
            StudentApplication createdApplication = create(StudentApplicationFactory.createStudentApplication(studentId, authentication.getName(), applicationForms));

            if(createdApplication != null){
                response.isSuccessful = true;

                response.data = createdApplication.toString();
            }
        }catch (IOException e){
            System.out.println(e);
        }

        return response.toString();
    }

    @Override
    public Set<StudentApplication> getAll(Authentication authentication) {
        if(isAdmin(authentication)) return new HashSet<>(this.repository.findAll());
        return null;
    }

    @Override
    public String getApplication(Authentication authentication) {
        Response response = new Response();

        //Get application using authenticated username
        StudentApplication application = read(authentication.getName());

        if(application == null) {
            response.isSuccessful = false;
            response.message = "NOT_FOUND";
            return response.toString();
        }

        //Restrict access to admins or the owners of the application
        if(isAdmin(authentication) || isApplicationOwner(application, authentication)) {
           response.isSuccessful = true;
           response.data = application.toString();
        }
        else{
            response.isSuccessful = false;
            response.message = "FORBIDDEN";
        }
        return response.toString();
    }

    @Override
    public StudentApplication getApplicationByStudentNumber(String studentNumber) {
        return null;

    }

    @Override
    public StudentApplication setStatus(String applicationId, String status, Authentication authentication) {
        StudentApplication application = read(applicationId);
        if(application != null){
            if(isAdmin(authentication)){
                StudentApplication updatedApplication = new StudentApplication.Builder().copy(application).setApplicationStatus(status).build();
                return repository.save(updatedApplication);
            }
        }
        return null;
    }

    private boolean isAdmin(Authentication authentication){
        for (GrantedAuthority authority : authentication.getAuthorities())
            if(authority.getAuthority().equals("admin")) return true;

        return false;
    }
    private boolean isApplicationOwner(StudentApplication application, Authentication authentication){
        if(application.getOwnerUsername().equals(authentication.getName())) return true;
        return false;
    }

    public class Response{
        boolean isSuccessful = false;
        String message = "";
        String data = "";

        @Override
        public String toString() {
            return "{\"isSuccessful\":" + isSuccessful + ", \"message\":\"" + message + "\"" + ", \"data\":" + data + "}";
        }
    }
}
