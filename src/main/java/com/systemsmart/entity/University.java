package com.systemsmart.entity;
//Finshed fixing eras
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 05/07/2020*/

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class University implements Serializable {

    @Id
    private int universityId;
    private String universityName;

    protected University(){

    }

    private University (Builder builder){
        this.universityId = builder.universityId;
        this.universityName = builder.universityName;
    }

    public int getUniversityId() {
        return universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityId=" + universityId +
                ", universityName='" + universityName + '\'' +
                '}';
    }

    public static class Builder{
        private int universityId;
        private String universityName;

        public Builder setUniversityId(int universityId) {
            this.universityId = universityId;
            return this;
        }

        public Builder setUniversityName(String universityName){
            this.universityName = universityName;
            return this;
        }

        public Builder copy(University university){
            this.universityId = university.universityId;
            this.universityName = university.universityName;
            return this;
        }

        public University build(){
            return new University(this);
        }
    }

}
