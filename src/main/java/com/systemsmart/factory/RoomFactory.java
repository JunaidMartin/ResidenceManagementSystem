package com.systemsmart.factory;

import com.systemsmart.entity.Room;

public class RoomFactory {
    public static Room createRoom(String type) {
        return new Room.Builder().setRoomNumber(roomNumber)
                .setType(type).setPrice((int) price)
                .setStatus(status).build();
    }


}

