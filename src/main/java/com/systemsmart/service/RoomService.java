package com.systemsmart.service;

import com.systemsmart.entity.Room;

import java.util.Set;

public interface RoomService extends IService<Room, String, Room >{
    Set<Room> getAll();

    Set<Room> getAllStatingWithA();



}
