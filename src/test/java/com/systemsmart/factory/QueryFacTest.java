package com.systemsmart.factory;

import com.systemsmart.entity.Query;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

//import static org.junit.jupiter.api.Assertions.assertTimeout;

/*  Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
    Description: This class performs some tests on the Complaint Factory class
    Date: 05 July 2020
*/


public class QueryFacTest {
    @Test
    public void ObjectEqualityTest() {
        Query logComplaint = QueryFactory.logQuery("Complaint", "There is a leak in the ceiling.", "Processing", "Hi, I will sort the problem out by this coming Wednesday. Thanks");
        Assert.assertEquals("Complaint", logComplaint.getNature());
    }

    @Test
    public void timeoutNotExceededTest()
    {
        /*assertTimeout(ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
        });*/
    }

    @Ignore
    @Test
    public void testDisabled(){
        Query logComplaint = QueryFactory.logQuery("Complaint", "There is a leak in the ceiling.", "Processing", "Hi, I will sort the problem out by this coming Wednesday. Thanks");
        Assert.assertEquals("Complaint", logComplaint.getNature());
    }
}


