package com.systemsmart.factory;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 05/07/2020*/

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
