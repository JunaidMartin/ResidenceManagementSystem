package com.systemsmart.service;

import com.systemsmart.entity.Address;

import java.util.Set;

public interface AddressService<R> extends IService<Address, String, Address> {
    Set<Address> getAll(Address[] addreses);

    Set<Address> getAllStatingWithA();
}
