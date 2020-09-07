package com.systemsmart.service.impl;

import com.systemsmart.entity.Student;
import com.systemsmart.repository.StudentRepository;
import com.systemsmart.repository.impl.StudentRepositoryImpl;
import com.systemsmart.service.StudentService;

import java.util.HashSet;
import java.util.Set;

/*
 * Author: Junaid Martin <216178606@mycput.ac.za>
 * Date: 07 September 2020
 */
public class StudentServiceImpl implements StudentService {

    private static StudentService service = null;
    private StudentRepository repository;

    private StudentServiceImpl(){
        this.repository = StudentRepositoryImpl.getRepository();
    }

    public static StudentService getService(){
        if (service == null) service = new StudentServiceImpl();
        return service;
    }

    @Override
    public Set<Student> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Set<Student> getStudentsWithStudentNumbers216() {
        Set<Student> students = getAll();
        Set<Student> studentsWith216 = new HashSet<>();
        for (Student student : students) {
            if (student.getStudNum().trim().startsWith("216")){
                studentsWith216.add(student);
            }
        }
        return studentsWith216;
    }

    @Override
    public Student create(Student student) {
        return this.repository.create(student);
    }

    @Override
    public Student read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Student update(Student student) {
        return this.repository.update(student);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
