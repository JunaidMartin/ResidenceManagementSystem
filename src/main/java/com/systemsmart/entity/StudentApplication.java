package com.systemsmart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Date:  13 November 2020
 */

@Entity
public class StudentApplication {

    @Id
    private int applicationId;
    private int studentId;
    private String applicationForms;

    protected StudentApplication(){}

    public StudentApplication(Builder builder) {
        this.applicationId =  builder.applicationId;
        this.studentId = builder.studentId;
        this.applicationForms = builder.applicationForms;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getApplicationForms() {
        return applicationForms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentApplication that = (StudentApplication) o;
        return applicationId == that.applicationId &&
                studentId == that.studentId &&
                Objects.equals(applicationForms, that.applicationForms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId, studentId, applicationForms);
    }

    public static class Builder{
        private int applicationId;
        private int studentId;
        private String applicationForms;

        public Builder setApplicationId(int applicationId) {
            this.applicationId = applicationId;
            return this;
        }

        public Builder setStudentId(int studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setApplicationForms(String applicationForms) {
            this.applicationForms = applicationForms;
            return this;
        }

        public Builder copy (StudentApplication studentApplication) {
            this.applicationId = studentApplication.getApplicationId();
            this.studentId = studentApplication.getStudentId();
            this.applicationForms = studentApplication.getApplicationForms();
            return this;
        }

        public StudentApplication build(){
            return new StudentApplication(this);
        }
    }
}
