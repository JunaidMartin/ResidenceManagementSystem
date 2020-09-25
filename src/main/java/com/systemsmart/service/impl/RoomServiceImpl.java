package com.systemsmart.service.impl;
//216279631 Mzileni Inga
import com.systemsmart.entity.Room;
import com.systemsmart.repository.RoomRepository;
import com.systemsmart.repository.impl.RoomRepositoryImpl;
import com.systemsmart.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository repository;
    private static RoomService service = null;


    private  RoomServiceImpl(){
        this.repository = RoomRepositoryImpl.getRoomRepository();

    }
    public static RoomService getService(){
        if(service == null) service  = new RoomServiceImpl();
        return service;

    }

    @Override
    public Set<Room> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Set<Room> getRoomService() {
        Set<Room> room = getAll();
        for (Room rooms : room)
            if (room.toString().trim().startsWith("100")) {
                room.add(rooms);
            }
        return room;
    }

    @Override
    public Room create(Room room) {
        return this.repository.create(room);
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

