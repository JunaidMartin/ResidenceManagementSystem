//package com.systemsmart.repository.impl;
////216279631 Mzileni Inga
//import com.systemsmart.entity.Address;
//import com.systemsmart.factory.AddressFactory;
//import com.systemsmart.repository.AddressRepository;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Set;
//
//import static org.junit.Assert.assertEquals;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class AddressRepositoryImplTest {
//
//    @Autowired
//    private static AddressRepository repository;
//
//    private static Address address = AddressFactory.createAddress("012345", "2591", "Msenge", "Philippi", "Cape Town", "7785");
//
//    @Test
//    public void a_create() {
//        Address created = repository.create(address);
//        assertEquals(address.getAddressId(), created.getAddressId());
//        System.out.println("create: " + created);
//    }
//
//    @Test
//    public void b_read() {
//        Address read = repository.read(address.toString());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update() {
//        Address updated = new Address.Builder().copy(address).setAddressId("012345").build();
//        updated = repository.update(updated);
//
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete() {
//        repository.delete(address.getAddressId());
//    }
//
//    @Test
//    public void d_getAll() {
//        Set<Address> address = repository.getAll();
//        assertEquals(1, address.size());
//        System.out.println(repository.getAll());
//    }
//}