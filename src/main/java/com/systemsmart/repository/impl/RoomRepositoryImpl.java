//package com.systemsmart.repository.impl;
//
//import com.systemsmart.entity.Room;
//import com.systemsmart.repository.RoomRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class RoomRepositoryImpl implements RoomRepository {
//
//    private Set<Room> numberDB;
//    private static RoomRepository roomRepository = null;
//
//
//    private RoomRepositoryImpl(){
//        this.numberDB = new HashSet<>();
//
//    }
//    public  static RoomRepository getRoomRepository() {
//        if (roomRepository == null) roomRepository = new RoomRepositoryImpl();
//        return roomRepository;
//
//
//    }
//
//        @Override
//    public Room create(Room t){
//        this.numberDB.add(t);
//        return t;
//    }
//
//    @Override
//    public Room read(String number){
//        Room room = null;
//        for (Room r : this.numberDB) {
//            if (r.getType().equalsIgnoreCase(number)) {
//                room = r;
//                break;
//            }
//        }
//        return room;
//
//    }
//    @Override
//    public Room update(Room room){
//        Room oldRoom = read(room.getType());
//        if (oldRoom != null){
//            this.numberDB.remove(oldRoom);
//            this.numberDB.add(room);
//        }
//        return room;
//    }
//    @Override
//    public boolean delete(String number){
//        Room room = read(number);
//        if (room != null)
//            this.numberDB.remove(room);
//
//
//        return false;
//    }
//
//    @Override
//    public Set<Room> getAll() {
//        return this.numberDB;
//    }
//}
