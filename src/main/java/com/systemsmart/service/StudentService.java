package com.systemsmart.service;

import com.systemsmart.entity.Student;

import java.util.Set;

public interface StudentService extends IService <Student, String, A> {
    Set<Student> getAll();
    // unique business logic as per student.
    Set<Student> getStudentsWithStudentNumbers216();
}
