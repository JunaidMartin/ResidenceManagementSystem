package com.systemsmart.entity;

/* Author: @Junaid Martin <216178606@mycput.ac.za>
Description: Student Entity to act as the end user of the system.
Date: 05/07
*/
public class Student{
    private String studNum;
    private String firstName;
    private String lastName;
    private String campus;
    private long identityNum;
    private String studEmail;
    private String contactNum;

    public Student(Builder builder) {
        this.studNum = builder.studNum;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.campus = builder.campus;
        this.identityNum = builder.identityNum;
        this.studEmail = builder.studEmail;
        this.contactNum = builder.contactNum;
    }

    // Getters
    public String getStudNum() {
        return studNum;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCampus() {
        return campus;
    }
    public long getIdentityNum() {
        return identityNum;
    }
    public String getStudEmail() {
        return studEmail;
    }
    public String getContactNum() {
        return contactNum;
    }

    //Builder Class
    public static class Builder{
        private String studNum;
        private String firstName;
        private String lastName;
        private String campus;
        private long identityNum;
        private String studEmail;
        private String contactNum;

        public Builder setStudNum (String studNum){
            this.studNum = studNum;
            return this;
        }
        public Builder setFirstName (String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder setLastName (String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder setCampus (String campus){
            this.campus = campus;
            return this;
        }
        public Builder setIdentityNum (long identityNum){
            this.identityNum = identityNum;
            return this;
        }
        public Builder setStudEmail (String studEmail){
            this.studEmail = studEmail;
            return this;
        }
        public Builder setContactNum (String contactNum){
            this.contactNum = contactNum;
            return this;
        }

        public Builder copy(Student student){
            this.studNum = student.studNum;
            this.firstName = student.firstName;
            this.lastName = student.lastName;
            this.campus = student.campus;
            this.identityNum = student.identityNum;
            this.studEmail = student.studEmail;
            this.contactNum = student.contactNum;
            return this;
        }

        public Student build(){
            return new Student(this);
        }

    }
}
