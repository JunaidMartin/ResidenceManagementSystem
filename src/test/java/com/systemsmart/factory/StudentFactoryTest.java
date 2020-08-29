package com.systemsmart.factory;

import com.systemsmart.entity.Student;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/* Author: @Junaid Martin <216178606@mycput.ac.za>
Description: StudentFactory Test file.
Date: 05/07
*/
public class StudentFactoryTest {

    @Test
    public void createStudent() {
        Student student = StudentFactory.createStudent("216178606", "Junaid", "Martin",
                "CPUT District Six Campus", 9707105208087L, "216178606@mycput.ac.za", "0798159723");
        Assert.assertEquals(216178606, student.getStudNum());
    }
}
