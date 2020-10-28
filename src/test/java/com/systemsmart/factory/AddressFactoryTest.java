package com.systemsmart.factory;

import com.systemsmart.entity.Address;
import org.junit.Assert;
import org.junit.Test;

//  Author:  Inga Mzileni <216279631@mycput.ac.za>


public class AddressFactoryTest {

    @Test
    public void createAddress() {
            Address address = AddressFactory.createAddress("012345", "2591", "Msenge", "Philippi", "Cape Town", "7785");
            Assert.assertEquals("012345", address.getAddressId());
        }
    }

