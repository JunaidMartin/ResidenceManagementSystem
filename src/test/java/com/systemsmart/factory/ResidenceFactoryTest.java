package com.systemsmart.factory;

import com.systemsmart.entity.Residence;
import org.junit.Assert;
import org.junit.Test;

/* Author: Brandon Eugene Charles <218220065@mycput.ac.za>
 * Description: Test class for ResidenceFactory
 * Date: 05/07
 */
public class ResidenceFactoryTest {

    @Test
    public void createResidence(){
        Residence res = ResidenceFactory.createResidence(223, 5, "Luxury Residence");
        Assert.assertEquals(223, res.getResidenceId());
    }
}
