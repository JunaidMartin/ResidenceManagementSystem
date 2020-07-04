package com.systemsmart.entity;

public class Room {
    private long roomNumber;
    private String  type;
    private int price;
    private boolean status;

    private Room(Builder builder){
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

}


