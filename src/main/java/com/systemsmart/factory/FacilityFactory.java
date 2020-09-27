package com.systemsmart.factory;
/*@ Author: Luzuko Tshaka  <216007542@mycput.ac.za>
  @ description : Domain Driven Design - Facility Factory
  @ Date: -05/07/2020
*/

import com.systemsmart.entity.Facility;

public class FacilityFactory {

    public static Facility createFacility(String facilityId,boolean laundromat, boolean studyRoom, boolean disabledFriendly, boolean securityPersonnel, boolean universityTransport,
                                          boolean computerEquipment, boolean wifiAccess, String electricitySystem){


        Facility facility = new Facility.Builder()
                .setFacilityId(facilityId)
                .setLaundromat(laundromat)
                .setStudyRoom(studyRoom)
                .setDisabledFriendly(disabledFriendly)
                .setSecurityPersonnel(securityPersonnel)
                .setUniversityTransport(universityTransport)
                .setComputerEquipment(computerEquipment)
                .setWifiAccess(wifiAccess)
                .setElectricitySystem(electricitySystem)
                .build();
        return facility;

    }

}
