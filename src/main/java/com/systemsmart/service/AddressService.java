package com.systemsmart.service;

import com.systemsmart.entity.Address;

import java.util.Set;

public interface AddressService<R> extends IService<Address, String, Address> {
    Set<Address> getAll(Address[] addreses);

    Set<Address> getAllStatingWithA();

    Address create(Address t);

    Address read(String s);

    Address update(Address t);

    boolean delete(String s);
}
