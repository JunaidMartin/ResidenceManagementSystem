package com.systemsmart.entity;

public class Student extends UserType{

    public Student(){
    }
    public Student(Builder builder) {
        super(builder);
    }

    public static class Builder extends UserType.Builder{

        public Builder() {
            super();
        }

        public Builder copy(Student student){
            super.setGuest(student.getGuest());
            super.setUserID(student.getUserID());
            super.setFirstName(student.getFirstName());
            super.setLastName(student.getLastName());
            return this;
        }

        @Override
        public UserType build(){
            return new Student(this);
        }

    }
}
