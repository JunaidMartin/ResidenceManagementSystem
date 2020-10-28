//package com.systemsmart.repository.impl;
//
//import com.systemsmart.entity.Address;
//import com.systemsmart.repository.AddressRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class AddressRepositoryImpl implements AddressRepository {
//
//    private Set<Address> addressDB;
//    private static AddressRepository addressRepository = null;
//
//
//    private  AddressRepositoryImpl(){
//        this.addressDB = new HashSet<>();
//
//    }
//    public  static AddressRepository getAddressRepository(){
//        if(addressRepository == null) addressRepository = new AddressRepositoryImpl();
//        return addressRepository;
//
//    }
//
//
//    @Override
//    public Address create(Address t){
//        this.addressDB.add(t);
//        return t;
//    }
//
//    @Override
//    public Address read(String s) {
//        for (Address address : this.addressDB){
//            if (address.toString().equalsIgnoreCase(s)) return address;
//        }
//        return null;
//    }
//
//
//    @Override
//    public Address update(Address address){
//        Address oldAddress = read(address.getAddressId());
//        if (oldAddress != null){
//            this.addressDB.remove(oldAddress);
//            this.addressDB.add(address);
//        }
//        return address;
//    }
//    @Override
//    public boolean delete(String street){
//        Address address = read(street);
//        if (address != null)
//            this.addressDB.remove(address);
//
//
//        return false;
//    }
//    @Override
//    public Set<Address> getAll() {
//        return this.addressDB;
//    }
//}