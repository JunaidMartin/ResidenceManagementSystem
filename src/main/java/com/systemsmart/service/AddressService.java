package com.systemsmart.service;

import com.systemsmart.entity.Address;

import java.util.Set;

public interface AddressService extends IService<Address, String> {
    Set<Address> getAddressId();

    Set<Address> getAll();

}