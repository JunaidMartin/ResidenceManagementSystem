package com.systemsmart.factory;

import com.systemsmart.entity.Complaint;

/*  Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
    Description: This class instantiates the Complaint object
    Date: 05 July 2020
*/

public class ComplaintFactory {

    public static Complaint logComplaint(long complaintID, String description, String logStatus){

        Complaint c = new Complaint.Builder().setComplaintID(complaintID).setDescription(description).setLogStatus(logStatus).build();

        return c;

    }
}
