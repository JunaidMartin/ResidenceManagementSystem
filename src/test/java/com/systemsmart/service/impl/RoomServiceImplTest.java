package com.systemsmart.service.impl;

import com.systemsmart.entity.Address;
import com.systemsmart.entity.Room;
import com.systemsmart.factory.RoomFactory;
import com.systemsmart.service.RoomService;
import org.junit.Test;

import java.util.Set;
/* Inga Mzileni RoomService*/

class RoomServiceImplTest {

    private static RoomService service = RoomServiceImpl.getService();
    private static Room room = RoomFactory.createRoom("available");
    private Object Room;


    @org.junit.Test
    public void getAll() {
        Set<Address> room = null;
        room = service.getAll(room);
        assertEquals(room.toString());
        System.out.println("All Room: "+ room);
    }

    private void assertEquals(String toString) {
    }

    private void assertEquals(com.systemsmart.entity.Room.Builder toString, String i) {
    }

    @Test
    public void create() {
        Room create = service.create((com.systemsmart.entity.Room) Room);
        assertEquals(new Room.Builder(), create.toString());

    }

    @org.junit.Test
    public void read() {
        Room read = service.read(room.toString());
        System.out.println("Read: "+ read);
    }

    @org.junit.Test
    public void update() {
        Room updated = new Room.Builder().copy(room).build("Room 100").build();
        updated = service.update(updated);

    }

   }