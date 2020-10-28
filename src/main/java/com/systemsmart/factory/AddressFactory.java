package com.systemsmart.factory;

import com.systemsmart.entity.Address;

public class AddressFactory {
    public static Address createAddress(String addressId, String streetNum, String streetName, String suburb, String city, String postalCode){
        return  new Address.Builder().setAddressId(addressId).
                setStreetNum(streetNum).
                setStreetName(streetName).
                setSuburb(suburb).setCity(city).
                setPostal(postalCode).build();
    }

}
