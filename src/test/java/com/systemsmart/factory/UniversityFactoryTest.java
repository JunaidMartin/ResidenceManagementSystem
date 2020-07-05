package com.systemsmart.factory;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 05/07/2020*/

import com.systemsmart.entity.University;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniversityFactoryTest {

    @Test
    public void createUniversity() {
        University university = UniversityFactory.createUniversity("CPUT");

        Assert.assertEquals("CPUT", university.getUniversityName());
    }
}