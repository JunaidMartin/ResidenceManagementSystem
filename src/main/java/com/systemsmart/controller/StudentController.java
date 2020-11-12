package com.systemsmart.controller;

import com.systemsmart.entity.Student;
import com.systemsmart.factory.StudentFactory;
import com.systemsmart.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping ("/create")
    public Student create(@RequestBody Student student){
        Student newStudent = StudentFactory.buildStudent(student.getStudNum(), student.getFirstName(),
                student.getLastName(), student.getGender(), student.getDob(), student.getIdentityNum(),
                student.getHomeLanguage(), student.getContactNum(), student.getCampusId(), student.getStudEmail(),
                student.getResId());
        return studentService.create(newStudent);
    }

    @GetMapping("/read/{id}")
    public Student read(@PathVariable String id){
        return studentService.read(id);
    }

    @PostMapping ("/update")
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }

    @GetMapping("/all")
    public Set<Student> getall(){
        return studentService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return studentService.delete(id);
    }
}
