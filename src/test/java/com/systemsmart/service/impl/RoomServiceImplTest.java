package com.systemsmart.service.impl;

import com.systemsmart.entity.Room;
import com.systemsmart.factory.RoomFactory;
import com.systemsmart.service.RoomService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class RoomServiceImplTest {
    private static RoomService service = RoomServiceImpl.getService();
    private static com.systemsmart.entity.Room room = RoomFactory.createRoom("available");
    private static Object Room;


    @Test
    public void d_getAll() {
        Set<Room> room = service.getAll();
        assertEquals(1, room.size());
        System.out.println("Room details " + room);

    }

    @Test
    public void a_create() {
        Room create = service.create(room);
        Assert.assertEquals(room.getType(), create.getType());
        System.out.println("create: " + create);
    }

    @Test
    public void b_read() {

        Room read = service.read(room.getType());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Room update = new Room.Builder().copy(room).build();
        update = service.update(update);
        System.out.println("update: " + update);
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(room.getType());
        Assert.assertTrue(deleted);
    }

}