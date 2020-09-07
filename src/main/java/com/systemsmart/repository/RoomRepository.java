package com.systemsmart.repository;

import com.systemsmart.entity.Room;
import com.systemsmart.repository.IRepository;
import com.systemsmart.service.RoomService;

import java.util.Set;

public interface RoomRepository extends IRepository <Room, String> {
    static void getRepository() {
    }

    Set<Room> getAll();
}