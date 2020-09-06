package com.systemsmart.service.impl;

import com.systemsmart.entity.Address;
import com.systemsmart.factory.AddressFactory;
import com.systemsmart.service.AddressService;
import org.junit.Test;

import java.util.Set;

public class AddressServiceImplTest {

    private static AddressService service = (AddressService) RoomServiceImpl.getService();
    private static Address address = AddressFactory.createAddress("2591 Msenge Street");
    private Object Address;

    @org.junit.Test
    public void getAll() {
        com.systemsmart.entity.Address[] addreses = new Address[0];
        Set<Address> address = service.getAll(addreses);
        assertEquals(1, address.size());
        System.out.println("All address: "+ address);
        
    }

    private void assertEquals(int i, int size) {
    }

    private void assertEquals(com.systemsmart.entity.Address.Builder i, String size) {
    }

    @Test
    public void create() {
        Address create = (com.systemsmart.entity.Address) service.create(Address);
        assertEquals(new Address.Builder(), create.toString());

    }

    @org.junit.Test
    public void read() {
        Address read = (com.systemsmart.entity.Address) service.read(address.toString());
        System.out.println("Read: "+ read);
    }

    @org.junit.Test
    public void update() {
        Address updated = new Address.Builder().copy(address).setStreet("2591 Msenge Street").build();
        updated = (com.systemsmart.entity.Address) service.update(updated);

        System.out.println("Updated: " + updated);
    }

    @org.junit.Test
    public void delete() {

            service.delete(address.toString());

    }
}