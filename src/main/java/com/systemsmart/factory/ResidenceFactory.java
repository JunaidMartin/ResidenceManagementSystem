package com.systemsmart.factory;

import com.systemsmart.entity.Residence;

public class ResidenceFactory {

    public static Residence createResidence(int residenceId, int numberOfRooms, String residenceName){
        return new Residence.Builder()
                .setName(residenceName)
                .setNumberOfRooms(numberOfRooms)
                .setResidenceId(residenceId)
                .build();
    }
}
