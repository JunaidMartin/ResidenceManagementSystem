package com.systemsmart.factory;

import com.systemsmart.entity.Address;

public class AddressFactory {
    public static Address createAddress(String street){
        return  new Address.Builder().setStreet(street).
                setSuburb(suburb).setCity(city).
                setPostel(postalCode).build();
    }

}
