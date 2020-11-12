package com.systemsmart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/* Author: Brandon Eugene Charles <218220065@mycput.ac.za>
Description: Residence Entity.
Date: 05/07
*/
@Entity
public class Residence implements Serializable {

    @Id
    private int residenceId;
    private int roomsAvailable;
    private String residenceName;

    protected Residence(){}

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

    @Override
    public String toString() {
        return "Residence{" +
                "residenceId="+ residenceId +
                ", roomsAvailable=" + roomsAvailable +
                ", residenceName=" + residenceName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Residence residence = (Residence) o;
        return residenceId == residence.residenceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(residenceId);
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
