package com.systemsmart.factory;

import com.systemsmart.entity.Residence;

/* Author: Brandon Eugene Charles <218220065@mycput.ac.za>
 * Description: ResidenceFactory to build Residence entity.
 * Date: 05/07
 */
public class ResidenceFactory {

    public static Residence createResidence(int residenceId, int numberOfRooms, String residenceName){
        return new Residence.Builder()
                .setName(residenceName)
                .setNumberOfRooms(numberOfRooms)
                .setResidenceId(residenceId)
                .build();
    }
}
