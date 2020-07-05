package com.systemsmart.entity;

public class Residence {

    private int residenceId;
    private int roomsAvailable;
    private String residenceName;

    public Residence(Builder builder) {
        this.residenceId =  builder.residenceId;
        this.roomsAvailable = builder.roomsAvailable;
        this.residenceName = builder.residenceName;
    }

    public int getResidenceId() {
        return residenceId;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public static class Builder{
        private String residenceName;
        private int roomsAvailable;
        private int residenceId;

        public Builder setResidenceId(int residenceId) {
            this.residenceId = residenceId;
            return this;
        }

        public Builder setName(String name) {
            this.residenceName = name;
            return this;
        }

        public Builder setNumberOfRooms(int numberOfRooms) {
            this.roomsAvailable = numberOfRooms;
            return this;
        }

        public Builder copy (Residence residence) {
            this.residenceName = residence.getResidenceName();
            this.roomsAvailable = residence.getRoomsAvailable();
            this.residenceId = residence.getResidenceId();
            return this;
        }

        public Residence build(){
            return new Residence(this);
        }
    }
}
