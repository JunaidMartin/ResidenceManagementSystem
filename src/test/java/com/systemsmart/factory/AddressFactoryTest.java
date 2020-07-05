package com.systemsmart.factory;

import com.systemsmart.entity.Address;
import org.junit.Assert;
import org.junit.Test;

public class AddressFactoryTest {

    @Test
    public void createAddress() {
            Address address = AddressFactory.createAddress("Kloof street", "Gardens", "Cape Town", 1800);
            Assert.assertEquals("Kloof street", address.getStreet());
        }
    }

