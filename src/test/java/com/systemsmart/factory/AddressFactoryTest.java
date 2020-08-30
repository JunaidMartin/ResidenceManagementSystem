package com.systemsmart.factory;

import com.systemsmart.entity.Address;
import org.junit.Assert;
import org.junit.Test;

//  Author:  Inga Mzileni <216279631@mycput.ac.za>


public class AddressFactoryTest {

    @Test
    public void createAddress() {
            Address address = AddressFactory.createAddress("Kloof street", "Philippi", "Cape Town", 7750);
            Assert.assertEquals("Kloof street", address.getStreet());
        }
    }

