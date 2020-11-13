package com.systemsmart.factory;

import com.systemsmart.entity.StudentApplication;
/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Date:  13 November 2020
 */
public class StudentApplicationFactory {
    public static StudentApplication createStudentApplication(int studentId, int applicationId, String applicationForms){
        return new StudentApplication.Builder()
                .setStudentId(studentId)
                .setApplicationId(applicationId)
                .setApplicationForms(applicationForms)
                .build();
    }
}
