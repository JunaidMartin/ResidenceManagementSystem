package com.systemsmart.factory;

import com.systemsmart.entity.Complaint;
import com.systemsmart.util.StringHelper;

/*  Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
    Description: This class instantiates the Complaint object
    Date: 05 July 2020
*/

public class ComplaintFactory {

    public static Complaint logComplaint(String nature, String description, String logStatus, String response){

        Complaint c = new Complaint.Builder()
                .setComplaintID(StringHelper.generateRandom())
                .setNature(nature)
                .setDescription(description)
                .setLogStatus(logStatus)
                .setResponse(response)
                .build();

        return c;

    }
}
