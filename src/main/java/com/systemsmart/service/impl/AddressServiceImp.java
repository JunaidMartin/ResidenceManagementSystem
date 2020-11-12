package com.systemsmart.service.impl;
//216279631 Mzileni Inga

import com.systemsmart.entity.Address;
import com.systemsmart.repository.AddressRepository;
import com.systemsmart.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressServiceImp implements AddressService {


    @Autowired
    private AddressRepository repository;


    @Override
    public Set<Address> getAddressId() {
        Set<Address> address = getAll();
        Set<Address> street = new HashSet<>();
        for (Address addresses : address) {
            if (addresses.getAddressId() == "012345") {
                street.add(addresses);
            }
        }
        return street;
    }

    @Override
    public Set<Address> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Address create(Address t) {
        return this.repository.save(t);
    }

    @Override
    public Address read(String o) {
        return this.repository.findById(o).orElseGet(null);

    }

    @Override
    public Address update(Address t) {
        if (this.repository.existsById(t.getAddressId())) {
            return this.repository.save(t);
        }
        return null;
    }
    @Override
    public boolean delete(String o) {
        this.repository.deleteById(o);
        if (this.repository.existsById(o)) return false;
        else return true;

    }
}