package com.systemsmart.repository.impl;
//216279631 Mzileni Inga
import com.systemsmart.entity.Room;
import com.systemsmart.factory.RoomFactory;
import com.systemsmart.repository.RoomRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomRepositoryImplTest {

    private static RoomRepository repository = RoomRepositoryImpl.getRoomRepository();
    private static Room room = RoomFactory.createRoom(14, "single room", 3500, true );


    @Test
    public void a_create() {
        Room created = repository.create(room);
        assertEquals(room.toString(), created.toString());
        System.out.println ("Created: " + created);
    }
    @Test

    public void b_read() {
        Room read = repository.read(room.toString());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Room updated = new Room.Builder().copy(room).setType("Single room").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        repository.delete(room.toString());
    }

    @Test
    public void d_getAll() {
        Set<Room> rooms = repository.getAll();
        assertEquals(1, rooms.size());
        System.out.println(repository.getAll());
    }
}