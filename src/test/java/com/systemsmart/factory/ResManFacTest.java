package com.systemsmart.factory;

import com.systemsmart.entity.ResidenceManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class ResManFacTest {

    @Test
    public void ObjectEqualityTest() {

        ResidenceManager rs = ResManagerFactory.resMan(217248756, "Joel", "Kutino");
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

        ResidenceManager rs = ResManagerFactory.resMan(217248756, "Joel", "Kutino");
        Assert.assertEquals("Kutino", rs.getLastName());
    }
}
