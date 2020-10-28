package com.systemsmart.entity;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 05/07/2020*/

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Campus implements Serializable {
   @Id
    private int campusId;
    private String name;

    protected Campus(){

    }

    private Campus (Builder builder){
        this.campusId = builder.campusId;
        this.name = builder.name;
    }

    public int getCampusId() {
        return campusId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "campusId=" + campusId +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder{
        private int campusId;
        private String name;

        public Builder setCampusId(int campusId){
            this.campusId = campusId;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder copy(Campus campus){
            this.campusId = campus.campusId;
            this.name = campus.name;
            return this;
        }

        public Campus build(){
            return new Campus(this);
        }
    }

}


