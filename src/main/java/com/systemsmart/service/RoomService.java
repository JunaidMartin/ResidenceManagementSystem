package com.systemsmart.service;
/*Inga Mzileni Room entity*/
import com.systemsmart.entity.Address;
import com.systemsmart.entity.Room;

import java.util.Set;

public interface RoomService extends IService<Room, String, Room >{
    Set<Address> getAll(Set<Address> addreses);

    Set<Address> getAllStatingWithA();


}
