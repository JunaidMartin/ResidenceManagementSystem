package com.systemsmart.factory;


import com.systemsmart.entity.Room;
import org.junit.Assert;
import org.junit.Test;

//  Author:  Inga Mzileni <216279631@mycput.ac.za>

public class RoomFactoryTest {

    @Test
    public void createRoom() {
        Room room = RoomFactory.createRoom("single room");
        Assert.assertEquals(10, room.getRoomNumber());
    }
}