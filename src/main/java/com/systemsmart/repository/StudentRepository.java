package com.systemsmart.repository;

import com.systemsmart.entity.Student;
import com.systemsmart.repository.IRepository;
import com.systemsmart.repository.StudentRepository;
import java.util.HashSet;
import java.util.Set;

public interface StudentRepository extends IRepository <Student, String> {
    Set<Student> getAll();
}
