package com.systemsmart.repository;

import com.systemsmart.entity.Address;
import com.systemsmart.repository.IRepository;

import java.util.Set;

public interface AddressRepository extends IRepository <Address, String> {
    static AddressRepository getRepository() {
    }

    Set<Address> getAll();

}
