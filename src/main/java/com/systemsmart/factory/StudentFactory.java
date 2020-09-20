package com.systemsmart.factory;

import com.systemsmart.entity.Student;

/* Author: @Junaid Martin <216178606@mycput.ac.za>
Description: StudentFactory to build Student Entity objects.
Date: 05/07
*/
public class StudentFactory {

    public static Student buildStudent(String studNum, String firstName, String lastName,
                                       String campus, long identityNum, String studEmail, String contactNum){
        Student student = new Student.Builder()
                .setStudNum(studNum)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setCampus(campus)
                .setIdentityNum(identityNum)
                .setStudEmail(studEmail)
                .setContactNum(contactNum)
                .build();
        return student;
    }

}
