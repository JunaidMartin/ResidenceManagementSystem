//package com.systemsmart.repository.impl;
////216279631 Mzileni Inga
//import com.systemsmart.entity.Room;
//import com.systemsmart.factory.RoomFactory;
//import com.systemsmart.repository.RoomRepository;
//import com.systemsmart.service.RoomService;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Set;
//
//import static org.junit.Assert.assertEquals;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class RoomRepositoryImplTest {
//
//    @Autowired
//    private static RoomRepository roomRepository;
//    private static Room room = RoomFactory.createRoom(14, "single room", 3500, true );
//
//
//    @Test
//    public void a_create() {
//        Room created = roomRepository.create(room);
//        assertEquals(room.toString(), created.toString());
//        System.out.println ("Created: " + created);
//    }
//    @Test
//
//    public void b_read() {
//        Room read = roomRepository.read(room.toString());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update() {
//        Room updated = new Room.Builder().copy(room).setType("Single room").build();
//        updated = roomRepository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete() {
//        roomRepository.delete(room.toString());
//    }
//
//    @Test
//    public void d_getAll() {
//        Set<Room> rooms = roomRepository.getAll();
//        assertEquals(1, rooms.size());
//        System.out.println(roomRepository.getAll());
//    }
//}