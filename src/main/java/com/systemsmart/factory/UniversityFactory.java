package com.systemsmart.factory;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 05/07/2020*/

import com.systemsmart.entity.University;

public class UniversityFactory {
    public static University createUniversity(int universityId, String universityName){
        University university = new University.Builder()
                .setUniversityId(universityId)
                .setUniversityName(universityName)
                .build();
        return university;
    }
}
