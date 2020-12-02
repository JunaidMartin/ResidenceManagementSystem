package com.systemsmart.factory;

import com.systemsmart.entity.Query;
import com.systemsmart.entity.Residence;
import com.systemsmart.util.StringHelper;

import java.util.UUID;

/*  Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
    Description: This class instantiates the Complaint object
    Date: 05 July 2020
*/

public class QueryFactory {
    public static Query createQuery(String queryId, String nature, String fullName, String studNum, String description, String logStatus, String response){
        return new Query.Builder()
                .setQueryId(UUID.randomUUID().toString())
                .setNature(nature)
                .setFullName(fullName)
                .setStudNum(studNum)
                .setDescription(description)
                .setLogStatus(logStatus)
                .setResponse(response)
                .build();
    }
}
