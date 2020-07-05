package com.systemsmart.factory;

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