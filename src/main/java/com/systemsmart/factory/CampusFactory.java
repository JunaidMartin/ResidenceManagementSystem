package com.systemsmart.factory;

import com.systemsmart.entity.Campus;

public class CampusFactory {
    public static Campus createCampus(int campusId, String campusName){
        Campus campus = new Campus.Builder()
                .setCampusId(campusId)
                .setName(campusName)
                .build();
        return campus;
    }
}
