/*
package com.systemsmart.repository.impl;

import com.systemsmart.entity.Student;
import com.systemsmart.factory.StudentFactory;
import com.systemsmart.repository.StudentRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentRepositoryImplTest {

    private static StudentRepository repository = StudentRepositoryImpl.getRepository();
    private static Student student = StudentFactory.buildStudent("216178606", "Junade", "Martin",
            "CPUT District Six Campus", 9707105208087L, "216178606@mycput.ac.za", "0798159723");

    @Test
    public void a_create() {
        Student created = repository.create(student);
        Assert.assertEquals(student.getStudNum(), created.getStudNum());
        System.out.println ("Created: " + created);
    }

    @Test
    public void b_read() {
        Student read = repository.read(student.getStudNum());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Student updated = new Student.Builder().copy(student).setFirstName("Junaid").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(student.getStudNum());
        Assert.assertTrue(deleted);
    }

    @Test
    public void d_getAll() {
        System.out.println("Get all: " + repository.getAll());
    }
}*/
