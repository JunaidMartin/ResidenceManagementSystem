package com.systemsmart.service.impl;

import com.systemsmart.entity.Student;
import com.systemsmart.factory.StudentFactory;
import com.systemsmart.service.StudentService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceImplTest {

    private static StudentService service = StudentServiceImpl.getService();
    private static Student student = StudentFactory.createStudent("216178606", "Junade", "Martin",
            "CPUT District Six Campus", 9707105208087L, "216178606@mycput.ac.za", "0798159723");

    @Test
    public void d_getAll() {
        Set<Student> students = service.getAll();
        assertEquals(1, students.size());
        System.out.println("All races: " + students);
    }

    @Test
    public void a_create() {
        Student created = service.create(student);
        Assert.assertEquals(student.getStudNum(), created.getStudNum());
        System.out.println ("Created: " + created);
    }

    @Test
    public void b_read() {
        Student read = service.read(student.getStudNum());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Student updated = new Student.Builder().copy(student).setFirstName("Junaid").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(student.getStudNum());
        Assert.assertTrue(deleted);

    }

    @Test
    public void e_getStudentsWithStudentNumbers216() {
    }
}