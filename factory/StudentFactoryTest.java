package com.systemsmart.factory;

import com.systemsmart.entity.Student;
import org.junit.Assert;
import org.junit.Test;

/* Author: @Junaid Martin <216178606@mycput.ac.za>
Description: StudentFactory Test file.
Date: 05/07
*/
public class StudentFactoryTest {

    @Test
    public void createStudent() {
        Student student = StudentFactory.buildStudent("123456789", "Junaid", "Martin",
                "Male", "10-Jul-1997", 1234567890123L, "English",
                "0798159723", 1, "123456789@mycput.ac.za", "Catsville");
        Assert.assertEquals(216178606, student.getStudNum());
    }
}
