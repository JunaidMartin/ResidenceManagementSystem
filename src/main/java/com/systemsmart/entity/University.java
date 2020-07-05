package com.systemsmart.entity;

public class University {

    private String universityName;

    private University (University.Builder builder){

        this.universityName = builder.universityName;
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

    public String getUniversityName() {
        return universityName;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "University{" +
                "universityName='" + universityName + '\'' +
                '}';
    }
}
