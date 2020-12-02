package com.systemsmart.service.impl;

import com.systemsmart.entity.Student;
import com.systemsmart.repository.StudentRepository;
import com.systemsmart.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Author: Junaid Martin <216178606@mycput.ac.za>
 * Date: 07 September 2020
 */

@Service
public class StudentServiceImpl implements StudentService {

    private static StudentService service = null;
    @Autowired
    private StudentRepository repository;

    @Override
    public Set<Student> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public String getStudentsFromResidence(String residenceName) {

        return null;
    }

/*    @Override
    public Set<Student> getStudentsWithStudentNumbers216() {
        Set<Student> students = getAll();
        Set<Student> studentsWith216 = new HashSet<>();
        for (Student student : students) {
            if (student.getStudNum().trim().startsWith("216")){
                studentsWith216.add(student);
            }
        }
        return studentsWith216;
    }*/

    @Override
    public Student create(Student student) {
        return this.repository.save(student);
    }

    @Override
    public Student read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Student update(Student student) {
        if (this.repository.existsById(student.getStudNum())){
            return this.repository.save(student);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)) return false;
        else return true;
    }
}
