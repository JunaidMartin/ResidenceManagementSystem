package com.systemsmart.service;

import com.systemsmart.entity.Student;
import org.springframework.security.core.Authentication;

import java.util.Set;
/*
 * Author: Junaid Martin <216178606@mycput.ac.za>
 * Date: 07 September 2020
 */
public interface StudentService extends IService <Student, String> {
    Set<Student> getAll();
    String getStudentsFromResidence(String residenceName);
    // unique business logic as per student.
//    Set<Student> getStudentsWithStudentNumbers216();
}
