package com.systemsmart.repository;

import com.systemsmart.entity.Address;

import java.util.Set;

public interface AddressRepository extends IRepository <Address, String> {
    static void getRepository() {
    }

    Set<Address> getAll();

}
