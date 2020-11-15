package com.systemsmart.factory;

import com.systemsmart.entity.Query;
import com.systemsmart.util.StringHelper;

/*  Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
    Description: This class instantiates the Complaint object
    Date: 05 July 2020
*/

public class QueryFactory {

    public static Query logQuery(String nature, String description, String logStatus, String response){

        Query c = new Query.Builder()
                .setQueryId(StringHelper.generateRandom())
                .setNature(nature)
                .setDescription(description)
                .setLogStatus(logStatus)
                .setResponse(response)
                .build();

        return c;

    }
}
