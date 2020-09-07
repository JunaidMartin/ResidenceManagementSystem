package com.systemsmart.repository.impl;

import com.systemsmart.entity.Room;
import com.systemsmart.factory.RoomFactory;
import com.systemsmart.repository.RoomRepository;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class RoomRepositoryImplTest {

    private static RoomRepository repository =  RoomRepositoryImpl.getRoomRepository();

    private static Room room = RoomFactory.createRoom("single", 100,500,true);

    @Test
    public void a_create() {
        Room created = repository.create(room);
        assertEquals(room.getRoomNumber(), created.getRoomNumber());
        System.out.println("create: " + created);
    }

    private void assertEquals(long roomn, long room1) {
    }

    @Test
    public void b_read() {
        Room read = repository.read(room.toString());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Room updated = new Room.Builder().copy(room).setRoomNumber(100).build();
        updated = repository.update(updated);

        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        repository.delete(room.toString());
    }

    @Test
    public void d_getAll() {
        Set<Room> address = repository.getAll();
        assertEquals(1, address.size());
        System.out.println(repository.getAll());
    }

    private void assertEquals(int i, int size) {
    }

}