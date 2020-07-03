package com.systemsmart.factory;

import com.systemsmart.entity.Student;
public class StudentFactory {

    public static Student getStudent(long userID, String firstName, String lastName){
        return (Student) new Student.Builder()
                .setUserID(userID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }
}
