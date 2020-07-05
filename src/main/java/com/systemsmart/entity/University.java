package com.systemsmart.entity;
//Finshed fixing eras
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 05/07/2020*/

public class University {

    private String universityName;

    private University (Builder builder){

        this.universityName = builder.universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "University{" +
                "universityName='" + universityName + '\'' +
                '}';
    }

    public static class Builder{

        private String universityName;

        public Builder setUniversityName(String universityName){
            this.universityName = universityName;
            return this;
        }

        public Builder copy(University university){

            this.universityName = university.universityName;
            return this;
        }

        public University build(){
            return new University(this);
        }
    }

}
