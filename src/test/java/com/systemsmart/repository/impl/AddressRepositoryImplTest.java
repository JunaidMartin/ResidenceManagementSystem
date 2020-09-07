package com.systemsmart.repository.impl;
/*Inga Mzileni Address entity*/

import com.systemsmart.entity.Address;
import com.systemsmart.factory.AddressFactory;
import com.systemsmart.repository.AddressRepository;
import org.junit.Test;

import java.util.Set;

public class AddressRepositoryImplTest {

    private static AddressRepository repository =  AddressRepositoryImpl.getAddressRepository();

    private static Address address = AddressFactory.createAddress("251 Msenge Street", "Philippi", "Cape Town", 7750);

    @Test
    public void a_create() {
        Address created = repository.create(address);
        assertEquals(address.getStreet(), created.getStreet());
        System.out.println("create: " + created);
    }

    private void assertEquals(String street, String street1) {
    }

    @Test
    public void b_read() {
        Address read = repository.read(address.toString());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Address updated = new Address.Builder().copy(address).setStreet("2591 Msenge Street").build();
        updated = repository.update(updated);

        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        repository.delete(address.toString());
    }

    @Test
    public void d_getAll() {
        Set<Address> address = repository.getAll();
        assertEquals(1, address.size());
        System.out.println(repository.getAll());
    }

    private void assertEquals(int i, int size) {
    }
}