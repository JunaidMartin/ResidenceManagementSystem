package com.systemsmart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/*  Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
    Description: This class specifies the attributes of the Complaint entity using builder pattern
    Date: 05 July 2020
*/
@Entity
public class Complaint implements Serializable {


    @Id
    private long complaintID;
    private String description;
    private String logStatus;

    protected Complaint(){}

    //constructor
    public Complaint(Builder builder) {
        this.complaintID = builder.complaintID;
        this.description = builder.description;
        this.logStatus = builder.logStatus;
    }


    //Getters


    public long getComplaintID() {
        return complaintID;
    }

    public String getDescription() {
        return description;
    }

    public String getLogStatus() {
        return logStatus;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                " complaintID: "+ complaintID +
                ", description: " + description +
                ", logStatus: " + logStatus + '\'' +
                '}';
    }

    //Builder

    public static class Builder{

        private long complaintID;
        private String description;
        private String logStatus;

        public Builder setComplaintID(long complaintID) {
            this.complaintID = complaintID;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setLogStatus(String logStatus) {
            this.logStatus = logStatus;
            return this;
        }


        public Builder copy(Complaint c){

            this.complaintID = c.complaintID;
            this.description = c.description;
            this.logStatus = c.logStatus;

            return this;
        }

        public Complaint build(){

            return new Complaint(this);
        }


    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaint complaint = (Complaint) o;
        return complaintID == complaint.complaintID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(complaintID);
    }
}
