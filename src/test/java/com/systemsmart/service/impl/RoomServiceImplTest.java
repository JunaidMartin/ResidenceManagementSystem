package com.systemsmart.service.impl;

import com.systemsmart.entity.Room;
import com.systemsmart.factory.RoomFactory;
import com.systemsmart.service.RoomService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomServiceImplTest {

    @Autowired
    private static RoomService service;
    private static Room room = RoomFactory.createRoom(14, "Single room" ,8500, true);



    @Test
    public void d_getAll() {
        Set<Room> room = service.getAll();
        assertEquals(1, room.size());
        System.out.println("Room details " + room);

    }

    @Test
    public void a_create() {
        Room created = service.create(room);
        Assert.assertEquals(room.toString(), created.toString());
        System.out.println ("Created: " + created);
    }

    @Test
    public void b_read() {
        Room read = service.read(room.toString());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Room updated = new Room.Builder().copy(room).build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(room.toString());
        Assert.assertTrue(deleted);

    }

}