package com.systemsmart.service;

import com.systemsmart.entity.Address;

import java.util.Set;

public interface AddressService<R> extends IService<Address, String> {
    Set<Address> getAddressStreet();

    Set<Address> getAll();

    Set<Address> getAllStatingWithA();

}