package com.systemsmart.factory;
/*@ Author: Luzuko Tshaka  <216007542@mycput.ac.za>
  @ description :  Facility Factory Test
  @ Date: -05/07
*/
import com.systemsmart.entity.Facility;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FacilityFactoryTest {

    @Test
    public void createFacility() {

        Facility facility = FacilityFactory.createFacility(true,true,true,
                true,true,true, " pre-paid electricity meter");

        Assert.assertEquals(true,facility.getStudyRoom());
    }
}