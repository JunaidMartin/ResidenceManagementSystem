package com.systemsmart.factory;

import com.systemsmart.entity.Complaint;

public class ComplaintFactory {

    public static Complaint logComplaint(long complaintID, String description, String logStatus){

        Complaint c = new Complaint.Builder().setComplaintID(complaintID).setDescription(description).setLogStatus(logStatus).build();

        return c;

    }
}
