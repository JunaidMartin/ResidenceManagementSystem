package com.systemsmart.factory;

import com.systemsmart.entity.Room;

public class RoomFactory {
    public static Room createRoom(String type, long roomNumber, double price, boolean status) {
        return new Room.Builder().setRoomNumber((int) roomNumber)
                .setType().setPrice((int) price)
                .setStatus(status).build("Room 100");
    }


    public static void createRoom(String available) {
    }
}

