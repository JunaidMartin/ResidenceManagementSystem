package com.systemsmart.entity;


public class Complaint {

    //Christ Kitenge Mbuyi (217248756)

    private long complaintID;
    private String description;
    private String logStatus;

    //constructor
    public Complaint(Builder builder) {
        this.complaintID = builder.complaintID;
        this.description = builder.description;
        this.logStatus = builder.logStatus;
    }

    //Setters

    public void setComplaintID(long complaintID) {
        this.complaintID = complaintID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus;
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
}
