package com.systemsmart.entity;

import java.io.Serializable;

//Finished fixing all errors
/*@ Author: Luzuko Tshaka  <216007542@mycput.ac.za>
  @ description : Domain Driven Design - Facility Entity
  @ Date: -05/07/2020
*/
public class Facility implements Serializable {

    private String facilityId;
    private boolean laundromat, studyRoom, disabledFriendly, securityPersonnel, universityTransport, computerEquipment,
            wifiAccess;
    private String electricitySystem;

    private Facility(){}

    public Facility(Builder builder){
        this.facilityId = builder.facilityId;
        this.laundromat = builder.laundromat;
        this.studyRoom = builder.studyRoom;
        this.disabledFriendly = builder.disabledFriendly;
        this.securityPersonnel = builder.securityPersonnel;
        this.universityTransport = builder.universityTransport;
        this.computerEquipment = builder.computerEquipment;
        this.wifiAccess = builder.wifiAccess;
        this.electricitySystem = builder.electricitySystem;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public boolean getLaundromat() {
        return laundromat;
    }

    public boolean getStudyRoom() {
        return studyRoom;
    }

    public boolean getDisabledFriendly() {
        return disabledFriendly;
    }

    public boolean getSecurityPersonnel() {
        return securityPersonnel;
    }

    public boolean getUniversityTransport() {
        return universityTransport;
    }

    public boolean getComputerEquipment() {
        return computerEquipment;
    }

    public boolean getWifiAccess() {
        return wifiAccess;
    }

    public String getElectricitySystem() {
        return electricitySystem;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "facilityId='" + facilityId + '\'' +
                ", laundromat=" + laundromat +
                ", studyRoom=" + studyRoom +
                ", disabledFriendly=" + disabledFriendly +
                ", securityPersonnel=" + securityPersonnel +
                ", universityTransport=" + universityTransport +
                ", computerEquipment=" + computerEquipment +
                ", wifiAccess=" + wifiAccess +
                ", electricitySystem='" + electricitySystem + '\'' +
                '}';
    }

    public static class Builder {

        private String facilityId;
        private boolean laundromat, studyRoom, disabledFriendly, securityPersonnel, universityTransport, computerEquipment,
                wifiAccess;
        private String electricitySystem;


        public Builder setFacilityId(String facilityId) {
            this.facilityId = facilityId;

            return this;
        }
        public Builder setLaundromat(boolean laundromat){

            this.laundromat = laundromat;

            return this;
        }

        public Builder setStudyRoom(boolean studyRoom){

            this.studyRoom = studyRoom;

            return this;
        }

        public Builder setDisabledFriendly(boolean disabledFriendly){

            this.disabledFriendly = disabledFriendly;

            return this;
        }

        public Builder setSecurityPersonnel(boolean securityPersonnel){

            this.securityPersonnel = securityPersonnel;

            return this;
        }

        public Builder setUniversityTransport(boolean universityTransport){

            this.universityTransport = universityTransport;

            return this;
        }

        public Builder setComputerEquipment(boolean computerEquipment){

            this.computerEquipment = computerEquipment;

            return this;
        }

        public Builder setWifiAccess(boolean wifiAccess){

            this.wifiAccess = wifiAccess;

            return this;
        }

        public Builder setElectricitySystem(String electricitySystem){

            this.electricitySystem = electricitySystem;

            return this;
        }

        public Builder copy(Facility facility){

            this.facilityId = facility.facilityId;
            this.laundromat = facility.laundromat;
            this.studyRoom = facility.studyRoom;
            this.disabledFriendly = facility.disabledFriendly;
            this.securityPersonnel = facility.securityPersonnel;
            this.universityTransport = facility.universityTransport;
            this.computerEquipment = facility.computerEquipment;
            this.wifiAccess = facility.wifiAccess;
            this.electricitySystem = facility.electricitySystem;
            return this;
        }


        public Facility build()
        {
            return new Facility(this);

        }


    }
}
