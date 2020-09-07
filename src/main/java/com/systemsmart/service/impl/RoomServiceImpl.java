package com.systemsmart.service.impl;
//216279631 Mzileni Inga
import com.systemsmart.entity.Room;
import com.systemsmart.repository.RoomRepository;
import com.systemsmart.service.RoomService;

import java.util.HashSet;
import java.util.Set;

public class RoomServiceImpl implements RoomService {

    private RoomService repository;
    private static RoomService service = null;


    private  RoomServiceImpl(){
        RoomRepository.getRepository();

    }
    public static RoomService getService(){
        if(service == null) service  = new com.systemsmart.service.impl.RoomServiceImpl();
        return service;

    }

    @Override
    public Set<Room> getAll() {
        return this.getAllStatingWithA();
    }

    @Override
    public Set<Room> getAllStatingWithA() {
        Set<Room> room = getAll();
        for (Room rooms : room)
            if (room.toString().trim().startsWith("100")) {
                room.add(rooms);
            }
        return room;
    }

    @Override
    public Room create(Room t) {
        return this.repository.create(t);
    }


    @Override
    public Room read(String s) {
        return this.repository.read(s);

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

