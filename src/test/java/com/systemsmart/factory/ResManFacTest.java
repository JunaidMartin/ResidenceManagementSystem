package com.systemsmart.factory;

import com.systemsmart.entity.ResidenceManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertTimeout;

/*  Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
    Description: This class performs some tests on the Residence Factory class
    Date: 05 July 2020
*/
public class ResManFacTest {

    @Test
    public void ObjectEqualityTest() {

        ResidenceManager rs = ResManagerFactory.resMan(217248756, "Joel", "Kutino", "10 Feb 2013", "Bellville", 7);
        Assert.assertEquals("Kutino", rs.getLastName());
    }

    @Test
    public void timeoutNotExceededTest()
    {

        assertTimeout(ofMinutes(2), () -> {
            // Perform tasks that takes less than 2 minutes.
        });
    }


    @Ignore
    @Test
    public void testDisabled(){

        ResidenceManager rs = ResManagerFactory.resMan(217248756, "Joel", "Kutino", "10 Feb 2013", "Bellville", 7);
        Assert.assertEquals("Kutino", rs.getLastName());
    }
}
