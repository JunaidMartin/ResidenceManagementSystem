package com.systemsmart.service.impl;
/*Inga Mzileni 216279631
* Address service*/

import com.systemsmart.entity.Address;
import com.systemsmart.repository.AddressRepository;
import com.systemsmart.service.AddressService;

import java.util.Set;


public class AddressServiceImpl implements AddressService {
    private AddressRepository repository;
    private static AddressService service = null;


    private  AddressServiceImpl(){
        this.repository = AddressRepository.getRepository();

    }
    public  static AddressService getService(){
        if(service == null) service  = new AddressServiceImpl();
        return service;

    }
    @Override
    public Set<Address> getAll(Address[] addreses) {
        return this.repository.getAll();
    }

    @Override
    public Set<Address> getAllStatingWithA() {
        return null;
    }

    @Override
    public Address create(Address t) {
        return repository.create(t);
    }

    @Override
    public Address read(String s) {
        return repository.read(s);
    }

    @Override
    public Address update(Address t) {
        return this.repository.update(t);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}