package com.systemsmart.factory;

import com.systemsmart.entity.Query;
import com.systemsmart.entity.Residence;
import com.systemsmart.util.StringHelper;

/*  Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
    Description: This class instantiates the Complaint object
    Date: 05 July 2020
*/

public class QueryFactory {

    public static Query createQuery(String queryId, String nature, String description, String logStatus, String response){
        return new Query.Builder()
                .setQueryId(queryId)
                .setNature(nature)
                .setDescription(description)
                .setLogStatus(logStatus)
                .setResponse(response)
                .build();
    }
}
