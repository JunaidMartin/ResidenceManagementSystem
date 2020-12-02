package com.systemsmart.entity;

import com.sun.istack.NotNull;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Objects;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Date:  13 November 2020
 */

@Entity
public class StudentApplication {

    @Id @Column(unique = true) @NotNull
    private String ownerUsername;

    @Column(unique = true) @NotNull
    private String studentId;

    @Lob
    private byte[] applicationForms;
    private String applicationFormType;
    private String applicationFormName;
    private String applicationStatus = "RECEIVED";
    private String submissionDate;

    protected StudentApplication(){}

    public StudentApplication(Builder builder) {
        this.studentId = builder.studentId;
        this.applicationForms = builder.applicationForms;
        this.applicationStatus = builder.applicationStatus;
        this.submissionDate = builder.submissionDate;
        this.ownerUsername = builder.ownerUsername;
        this.applicationFormName = builder.applicationFormName;
        this.applicationFormType = builder.applicationFormType;
    }

    public String getStudentId() {
        return studentId;
    }
    public byte[] getApplicationForms() {
        return applicationForms;
    }

    public String getApplicationFormType() {
        return applicationFormType;
    }

    public String getApplicationFormName() {
        return applicationFormName;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }
    public String getSubmissionDate() {
        return submissionDate;
    }
    public String getOwnerUsername() {
        return ownerUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentApplication that = (StudentApplication) o;
        return studentId.equals(that.studentId) &&
                ownerUsername.equals(that.ownerUsername) &&
                Objects.equals(applicationForms, that.applicationForms) &&
                Objects.equals(applicationStatus, that.applicationStatus) &&
                Objects.equals(submissionDate, that.submissionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, ownerUsername, applicationForms, applicationStatus, submissionDate);
    }

    @Override
    public String toString() {
        return "{" +
                "\"ownerUsername\":\"" + ownerUsername + "\"" +
                ", \"studentId\":\"" + studentId + "\"" +
                ", \"applicationForms\":\"" + applicationForms + "\"" +
                ", \"applicationFormName\":\"" + applicationFormName + "\"" +
                ", \"applicationFormType\":\"" + applicationFormType + "\"" +
                ", \"applicationStatus\":\"" + applicationStatus + "\"" +
                ", \"submissionDate\":\"" + submissionDate + "\"" +
                "}";
    }

    public static class Builder{
        private String ownerUsername;
        private String studentId;
        private byte[] applicationForms;
        private String applicationStatus = "RECEIVED";
        private String submissionDate;
        private String applicationFormType;
        private String applicationFormName;

        public Builder setSubmissionDate(String submissionDate) {
            this.submissionDate = submissionDate;
            return this;
        }
        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }
        public Builder setApplicationForms(byte[] applicationForms) {
            this.applicationForms = applicationForms;
            return this;
        }
        public Builder setApplicationStatus(String applicationStatus) {
            this.applicationStatus = applicationStatus;
            return this;
        }
        public Builder setOwnerUsername(String ownerUsername) {
            this.ownerUsername = ownerUsername;
            return this;
        }

        public Builder setApplicationFormType(String applicationFormType) {
            this.applicationFormType = applicationFormType;
            return this;
        }

        public Builder setApplicationFormName(String applicationFormName) {
            this.applicationFormName = applicationFormName;
            return this;
        }

        public Builder copy (StudentApplication studentApplication) {
            this.studentId = studentApplication.getStudentId();
            this.applicationForms = studentApplication.getApplicationForms();
            this.applicationStatus = studentApplication.getApplicationStatus();
            this.submissionDate = studentApplication.getSubmissionDate();
            this.ownerUsername = studentApplication.getOwnerUsername();
            this.applicationFormName = studentApplication.getApplicationFormName();
            this.applicationFormType = studentApplication.getApplicationFormType();
            return this;
        }

        public StudentApplication build(){
            return new StudentApplication(this);
        }
    }
}
