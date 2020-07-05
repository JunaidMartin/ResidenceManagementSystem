package com.systemsmart.factory;

import com.systemsmart.entity.University;

public class UniversityFactory {
    public static University createUniversity(String universityName){
        University university = new University.Builder()

                .setUniversityName(universityName)
                .build();
        return university;
    }
}
