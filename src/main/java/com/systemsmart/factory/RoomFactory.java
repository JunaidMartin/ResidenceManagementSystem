package com.systemsmart.factory;

import com.systemsmart.entity.Room;

public class RoomFactory {
    public static Room createRoom(long roomNumber, String type, int price, boolean status) {
        return new Room.Builder().setRoomNumber(roomNumber)
                .setType(type).setPrice((int) price)
                .setStatus(status).build();
    }
    private long roomNumber;
    private String  type;
    private int price;
    private boolean status;

}

