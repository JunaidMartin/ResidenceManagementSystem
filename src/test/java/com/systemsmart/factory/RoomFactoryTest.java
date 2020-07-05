package com.systemsmart.factory;


import com.systemsmart.entity.Room;
import org.junit.Assert;
import org.junit.Test;

public class RoomFactoryTest {

    @Test
    public void createRoom() {
        Room room = RoomFactory.createRoom(10, "single room", 500, true);
        Assert.assertEquals(10, room.getRoomNumber());
    }
}