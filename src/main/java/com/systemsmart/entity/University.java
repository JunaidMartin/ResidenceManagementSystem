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
    private String universityName;

    protected University(){

    }

    private University (Builder builder){

        this.universityName = builder.universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    @Override
    public String toString() {
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
