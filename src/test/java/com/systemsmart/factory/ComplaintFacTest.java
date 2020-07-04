package com.systemsmart.factory;

import com.systemsmart.entity.Complaint;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static java.time.Duration.ofMinutes;


public class ComplaintFacTest {

    @Test
    public void ObjectEqualityTest() {

        Complaint logComplaint = ComplaintFactory.logComplaint(2211, "The room i've booked is not the same as the one i see on the system", "processed");
        Assert.assertEquals(2211, logComplaint.getComplaintID());
    }


    @Test
    public void timeoutNotExceededTest()
    {

        assertTimeout(ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
        });
    }



    @Ignore
    @Test
    public void testDisabled(){

        Complaint logComplaint = ComplaintFactory.logComplaint(2211, "The room i've booked is not the same as the one i see on the system", "processed");
        Assert.assertEquals(2211, logComplaint.getComplaintID());
    }
}


