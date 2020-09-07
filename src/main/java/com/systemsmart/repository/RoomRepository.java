package com.systemsmart.repository;

import com.systemsmart.entity.Room;
import com.systemsmart.repository.IRepository;

import java.util.Set;

public interface RoomRepository extends IRepository <Room, String> {
    Set<Room> getAll();
}
