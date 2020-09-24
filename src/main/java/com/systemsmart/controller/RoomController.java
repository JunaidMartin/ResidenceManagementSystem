package com.systemsmart.controller;


import com.systemsmart.entity.Room;
import com.systemsmart.factory.RoomFactory;
import com.systemsmart.service.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomServiceImpl roomService;

    @PostMapping("/create")
    public Room create (@RequestBody Room room){
        Room newRoom = RoomFactory.createRoom(room.getRoomNumber(), room.getType(), room.getPrice(), room.getStatus());
        return roomService.create(newRoom);

    }
    @GetMapping("/all")
    public Set<Room> getAll(){
        return roomService.getAll();
    }

    @GetMapping("/read/{id}")
    public Room read(@PathVariable String id){
        return roomService.read(id);
    }
    @PostMapping ("/update")
    public Room update(@RequestBody Room room){
        return roomService.update(room);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return roomService.delete(id);
    }
}
