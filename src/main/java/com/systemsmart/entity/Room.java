package com.systemsmart.entity;

//  Author:  Inga Mzileni <216279631@mycput.ac.za>

public class Room {
    private String roomNumber;
    private String  type;
    private int price;
    private boolean status;

    public Room(Builder builder){
        this.roomNumber = builder.roomNumber;
        this.price = builder.price;
        this.type = builder.type;
        this.status = builder.status;
    }

    public Room() {

    }

    public String getRoomNumber() {
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

    public void build() {
    }

    public void getStreet() {
    }

    public void setType() {
    }

    public static class Builder{
        private String roomNumber;
        private int price;
        private String type;
        private boolean status;

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

        public Room build(String s){
            return new Room(this);
        }


        public void setRoomNumber(String roomNumber) {
        }

        public void setRoomNumber(int i) {
        }
    }

}


