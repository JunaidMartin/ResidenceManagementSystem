package com.systemsmart.factory;
/*@ Author: Luzuko Tshaka  <216007542@mycput.ac.za>
  @ description : Domain Driven Design - Facility Factory
  @ Date: -05/07/2020
*/

import com.systemsmart.entity.Facility;

public class FacilityFactory {

    public static Facility createFacility(Boolean laundromat, Boolean studyRoom, Boolean disabledFriendly, boolean securityPersonnel,
                                          boolean computerEquipment, boolean wifiAccess, String electricitySystem){


        Facility facility = new Facility.Builder()
                .setLaundromat(laundromat)
                .setStudyRoom(studyRoom)
                .setDisabledFriendly(disabledFriendly)
                .setSecurityPersonnel(securityPersonnel)
                .setComputerEquipment(computerEquipment)
                .setWifiAccess(wifiAccess)
                .setElectricitySystem(electricitySystem)
                .buil();
        return facility;

    }

}
