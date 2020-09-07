package com.systemsmart.service.impl;

import com.systemsmart.entity.Address;
import com.systemsmart.entity.Room;
import com.systemsmart.repository.RoomRepository;
import com.systemsmart.service.RoomService;

import java.util.Set;

public class RoomServiceImpl implements RoomService {

        private RoomService repository;
        private static RoomService service = null;


        private  RoomServiceImpl(){
            this.repository = RoomRepository.getRepository();

        }
        public static RoomService getService(){
            if(service == null) service  = new com.systemsmart.service.impl.RoomServiceImpl();
            return service;

        }
    @Override
    public Set<Address> getAll(Set<Address> addreses) {
        return this.repository.getAll(addreses);
    }

    @Override
    public Set<Address> getAllStatingWithA() {
        return null;
    }

    @Override
    public Room create(Room t) {
        return this.repository.create(t);
    }

    @Override
    public Address create(Address t) {
        return null;
    }

    @Override
    public Room read(String s) {
        return this.repository.read(s);

    }

    @Override
    public Address update(Address t) {
        return null;
    }

    @Override
    public Room update(Room t) {
        return this.repository.update(t);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
