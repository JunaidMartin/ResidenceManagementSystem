package com.systemsmart.factory;

import com.systemsmart.entity.StudentApplication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Date:  13 November 2020
 */
public class StudentApplicationFactory {
    public static StudentApplication createStudentApplication(String studentId, String ownerUsername, MultipartFile applicationForms) throws IOException{
        return new StudentApplication.Builder()
                .setStudentId(studentId)
                .setApplicationForms(applicationForms.getBytes())
                .setApplicationFormName(applicationForms.getOriginalFilename())
                .setApplicationFormType(applicationForms.getContentType())
                .setSubmissionDate(new Date().toString())
                .setOwnerUsername(ownerUsername)
                .build();
    }
}
