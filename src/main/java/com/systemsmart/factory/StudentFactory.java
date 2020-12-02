package com.systemsmart.factory;

import com.systemsmart.entity.Student;

/* Author: @Junaid Martin <216178606@mycput.ac.za>
Description: StudentFactory to build Student Entity objects.
Date: 05/07
*/
public class StudentFactory {

    public static Student buildStudent(String studNum, String firstName, String lastName, String gender,
                                       String dob, long identityNum, String homeLanguage,  String contactNum,
                                       int campusId, String studEmail, String residenceName){
        Student student = new Student.Builder()
                .setStudNum(studNum)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setDob(dob)
                .setIdentityNum(identityNum)
                .setHomeLanguage(homeLanguage)
                .setContactNum(contactNum)
                .setCampusId(campusId)
                .setStudEmail(studEmail)
                .setResidenceName(residenceName)
                .build();
        return student;
    }

}
