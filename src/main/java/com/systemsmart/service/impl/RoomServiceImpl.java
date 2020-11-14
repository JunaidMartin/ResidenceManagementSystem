package com.systemsmart.service.impl;
//216279631 Mzileni Inga

import com.systemsmart.entity.Room;
import com.systemsmart.repository.RoomRepository;
import com.systemsmart.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository repository;



    @Override
    public Set<Room> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
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
        return this.repository.save(room);
    }

    @Override
    public Room read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public  Room update(Room room) {
        if (this.repository.existsById(Long.toString(room.getRoomNumber()))){
            return this.repository.save(room);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)) return false;
        else return true;
    }
}

