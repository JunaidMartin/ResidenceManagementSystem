package com.systemsmart.repository;

import com.systemsmart.entity.Room;
import com.systemsmart.repository.IRepository;
import com.systemsmart.service.RoomService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface RoomRepository extends JpaRepository<Room, String>{


}