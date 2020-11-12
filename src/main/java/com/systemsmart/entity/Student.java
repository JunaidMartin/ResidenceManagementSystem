package com.systemsmart.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/* Author: @Junaid Martin <216178606@mycput.ac.za>
Description: Student Entity to act as the end user of the system.
Date: 05/07
*/
@Entity
public class Student implements Serializable {
    @Id
    private String studNum;
    private String firstName, lastName, gender, dob;
    private long identityNum;
    private String homeLanguage, contactNum;
    private int campusId, resId;
    private String studEmail;

    protected Student(){}

    public Student(Builder builder) {
        this.studNum = builder.studNum;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.dob = builder.dob;
        this.identityNum = builder.identityNum;
        this.homeLanguage = builder.homeLanguage;
        this.contactNum = builder.contactNum;
        this.campusId = builder.campusId;
        this.studEmail = builder.studEmail;
        this.resId = builder.resId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studNum='" + studNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", identityNum=" + identityNum +
                ", homeLanguage='" + homeLanguage + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", campusId=" + campusId +
                ", studEmail='" + studEmail + '\'' +
                ", resId='" + resId + '\'' +
                '}';
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
    public String getGender(){return gender;}
    public String getDob() {
        return dob;
    }
    public String getHomeLanguage() {
        return homeLanguage;
    }
    public int getCampusId() {
        return campusId;
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
    public int getResId() {return resId;}

    //Builder Class
    public static class Builder{
        private String studNum;
        private String firstName;
        private String lastName;
        private String gender;
        private String dob;
        private long identityNum;
        private String contactNum;
        private String homeLanguage;
        private int campusId;
        private String studEmail;
        private int resId;

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
        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }
        public Builder setDob(String dob) {
            this.dob = dob;
            return this;
        }
        public Builder setHomeLanguage(String homeLanguage) {
            this.homeLanguage = homeLanguage;
            return this;
        }
        public Builder setCampusId (int campusId){
            this.campusId = campusId;
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
        public Builder setResId(int resId) {
            this.resId = resId;
            return this;
        }

        public Builder copy(Student student){
            this.studNum = student.studNum;
            this.firstName = student.firstName;
            this.lastName = student.lastName;
            this.gender = student.gender;
            this.dob = student.dob;
            this.identityNum = student.identityNum;
            this.homeLanguage = student.homeLanguage;
            this.contactNum = student.contactNum;
            this.campusId = student.campusId;
            this.studEmail = student.studEmail;
            this.resId = student.resId;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }
}
