package com.systemsmart.controller;

import com.systemsmart.entity.Address;
import com.systemsmart.factory.AddressFactory;
import com.systemsmart.service.impl.AddressServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping ("/address")
public class AddressController {

    @Autowired
    private AddressServiceImp addressService;

    @PostMapping("/create")
    public Address create (@RequestBody Address address){
        Address newAddress = AddressFactory.createAddress(address.getStreet(), address.getSuburb(), address.getCity(),address.getPostalCode());
        return addressService.create(newAddress);
    }

    @GetMapping("/all")
    public Set<Address> getAll(){
        return  addressService.getAll();
    }

    @GetMapping("/read/{id}")
    public Address read(@PathVariable String id){
        return addressService.read(id);
    }

    @PostMapping ("/update")
    public Address update(@RequestBody Address address){
        return addressService.update(address);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return addressService.delete(id);
    }
}