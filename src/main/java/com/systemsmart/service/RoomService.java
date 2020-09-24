package com.systemsmart.service;

import com.systemsmart.entity.Room;

import java.util.Set;

public interface RoomService extends IService<Room, String >{
    Set<Room> getAll();

    Set<Room> getRoomService();



}
