package com.systemsmart.factory;

import com.systemsmart.entity.Student;
public class StudentFactory {

    public static Student createStudent(long studNum, String firstName, String lastName,
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
