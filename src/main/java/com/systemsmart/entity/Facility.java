package com.systemsmart.entity;
//Finished fixing all errors
/*@ Author: Luzuko Tshaka  <216007542@mycput.ac.za>
  @ description : Domain Driven Design - Facility Entity
  @ Date: -05/07/2020
*/
public class Facility {


    private Boolean laundromat, studyRoom, disabledFriendly, securityPersonnel, universityTransport, computerEquipment,
            wifiAccess;
    private String electricitySystem;

    private Facility(Builder builder){

        this.laundromat = builder.laundromat;
        this.studyRoom = builder.studyRoom;
        this.disabledFriendly = builder.disabledFriendly;
        this.securityPersonnel = builder.securityPersonnel;
        this.universityTransport = builder.universityTransport;
        this.computerEquipment = builder.computerEquipment;
        this.wifiAccess = builder.wifiAccess;
    }

    public String getFacilityID() {
        return facilityID;
    }

    public Boolean getLaundromat() {
        return laundromat;
    }

    public Boolean getStudyRoom() {
        return studyRoom;
    }

    public Boolean getDisabledFriendly() {
        return disabledFriendly;
    }

    public Boolean getSecurityPersonnel() {
        return securityPersonnel;
    }

    public Boolean getUniversityTransport() {
        return universityTransport;
    }

    public Boolean getComputerEquipment() {
        return computerEquipment;
    }

    public Boolean getWifiAccess() {
        return wifiAccess;
    }

    public String getElectricitySystem() {
        return electricitySystem;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "facilityId"+ facilityID +
                "laundromat=" + laundromat +
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

        private String facilityID;
        private Boolean laundromat, studyRoom, disabledFriendly, securityPersonnel, universityTransport, computerEquipment,
                wifiAccess;
        private String electricitySystem;


        public Builder setFacilityID(String facilityID) {
            this.facilityID = facilityID;

            return this;
        }
        public Builder setLaundromat(Boolean laundromat){

            this.laundromat = laundromat;

            return this;
        }

        public Builder setStudyRoom(Boolean studyRoom){

            this.studyRoom = studyRoom;

            return this;
        }

        public Builder setDisabledFriendly(Boolean disabledFriendly){

            this.disabledFriendly = disabledFriendly;

            return this;
        }

        public Builder setSecurityPersonnel(Boolean securityPersonnel){

            this.securityPersonnel = securityPersonnel;

            return this;
        }

        public Builder setUniversityTransport(Boolean universityTransport){

            this.universityTransport = universityTransport;

            return this;
        }

        public Builder setComputerEquipment(Boolean computerEquipment){

            this.computerEquipment = computerEquipment;

            return this;
        }

        public Builder setWifiAccess(Boolean wifiAccess){

            this.wifiAccess = wifiAccess;

            return this;
        }

        public Builder setElectricitySystem(String electricitySystem){

            this.electricitySystem = electricitySystem;

            return this;
        }

        public Builder copy(Facility facility){

            this.facilityID = facility.facilityID;
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
