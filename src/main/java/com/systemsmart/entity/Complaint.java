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
    private String complaintID;
    private String nature;
    private String description;
    private String logStatus;
    private String response;

    //constructor
    protected Complaint(){}

    public Complaint(Builder builder) {
        this.complaintID = builder.complaintID;
        this.nature = builder.nature;
        this.description = builder.description;
        this.logStatus = builder.logStatus;
        this.response = builder.response;
    }

    //Getters
    public String getComplaintID() {
        return complaintID;
    }
    public String getNature() {
        return nature;
    }
    public String getDescription() {
        return description;
    }
    public String getLogStatus() {
        return logStatus;
    }
    public String getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintID=" + complaintID +
                ", nature='" + nature + '\'' +
                ", description='" + description + '\'' +
                ", logStatus='" + logStatus + '\'' +
                ", response='" + response + '\'' +
                '}';
    }

    //Builder
    public static class Builder{
        private String complaintID;
        private String nature;
        private String description;
        private String logStatus;
        private String response;

        public Builder setComplaintID(String complaintID) {
            this.complaintID = complaintID;
            return this;
        }
        public Builder setNature(String nature) {
            this.nature = nature;
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
        public Builder setResponse(String response) {
            this.response = response;
            return this;
        }

        public Builder copy(Complaint c){

            this.complaintID = c.complaintID;
            this.nature = c.nature;
            this.description = c.description;
            this.logStatus = c.logStatus;
            this.response = c.response;

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
