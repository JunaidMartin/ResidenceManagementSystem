package com.systemsmart.entity;

//  Author:  Inga Mzileni <216279631@mycput.ac.za>

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Room implements Serializable {
    @Id
    private long roomNumber;
    private String  type;
    private int price;
    private boolean status;

    protected  Room(){}

    public Room(Builder builder){
        this.roomNumber = builder.roomNumber;
        this.price = builder.price;
        this.type = builder.type;
        this.status = builder.status;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void add(Room room) {
    }

    public static class Builder{
        private long roomNumber;
        private int price;
        private String type;
        private boolean status;

        public Builder setRoomNumber(long roomNumber){
            this.roomNumber = roomNumber;
            return this;
        }
        public Builder setPrice(int price){
            this.price = price;
            return this;
        }
        public Builder setType(String type){
            this.type = type;
            return this;
        }
        public Builder setStatus(boolean status){
            this.status = status;
            return this;
        }

        public  Builder copy(Room room){
            this.roomNumber = room.roomNumber;
            this.price = room.price;
            this.type = room.type;
            this.status = room.status;
            return this;
        }

        public Room build(){
            return new Room(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}


