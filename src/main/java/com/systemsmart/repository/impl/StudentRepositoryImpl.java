package com.systemsmart.repository.impl;

import com.systemsmart.entity.Student;
import com.systemsmart.repository.IRepository;
import com.systemsmart.repository.StudentRepository;
import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryImpl implements StudentRepository {

    private static StudentRepository repository = null;
    private Set<Student> studentDB;

    private StudentRepositoryImpl() {this.studentDB = new HashSet<>();}

    public static StudentRepository getRepository(){
        if (repository == null) repository =  new StudentRepositoryImpl();
        return repository;
    }

    @Override
    public Student create(Student student) {
        this.studentDB.add(student);
        return student;
    }

    @Override
    public Student read(String studNum) {
//        Student student = this.studentDB.stream().filter(s -> s.getStudNum().trim().equalsIgnoreCase(studentNum)).findAny().orElse(null);

        for (Student student : this.studentDB){
            if (student.getStudNum().equalsIgnoreCase(studNum)) return student;
        }
        return null;
    }

    @Override
    public Student update(Student student) {
        boolean deleteStudent = delete(student.getStudNum());
        if (deleteStudent){
            this.studentDB.add(student);
            return student;
        }
        return null;
    }

    @Override
    public boolean delete(String studNum) {
        Student student = read(studNum);
        if (student != null){
            this.studentDB.remove(student);
            return true;
        }
        return false;
    }

    @Override
    public Set<Student> getAll() {
        return this.studentDB;
    }
}
