package com.systemsmart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/* Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
Description: Query Entity.
Date: 05/07/2020
*/
@Entity
public class Query implements Serializable {
    @Id
    private String queryId;
    private String nature;
    private String fullName;
    private String studNum;
    private String description;
    private String logStatus;
    private String response;

    protected Query(){}

    public Query(Builder builder) {
        this.queryId =  builder.queryId;
        this.nature = builder.nature;
        this.fullName = builder.fullName;
        this.studNum = builder.studNum;
        this.description = builder.description;
        this.logStatus = builder.logStatus;
        this.response = builder.response;
    }

    //Getters
    public String getQueryId() {
        return queryId;
    }

    public String getNature() {
        return nature;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStudNum() {
        return studNum;
    }

    public String getDescription() {
        return description;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public String getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "Query{" +
                "queryId='" + queryId + '\'' +
                ", nature='" + nature + '\'' +
                ", fullName='" + fullName + '\'' +
                ", studNum='" + studNum + '\'' +
                ", description='" + description + '\'' +
                ", logStatus='" + logStatus + '\'' +
                ", response='" + response + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Query query = (Query) o;
        return queryId == query.queryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(queryId);
    }

    public static class Builder{
        private String queryId;
        private String nature;
        private String fullName;
        private String studNum;
        private String description;
        private String logStatus;
        private String response;

        public Builder setQueryId(String queryId) {
            this.queryId = queryId;
            return this;
        }

        public Builder setNature(String nature) {
            this.nature = nature;
            return this;
        }
        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }
        public Builder setStudNum(String studNum) {
            this.studNum = studNum;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setLogStatus(String logStatus) {
            this.logStatus = logStatus;
            return this;
        }

        public Builder setResponse(String response) {
            this.response = response;
            return this;
        }

        public Builder copy (Query query) {
            this.queryId = query.getQueryId();
            this.nature = query.getNature();
            this.fullName = query.getFullName();
            this.studNum = query.getStudNum();
            this.description = query.getDescription();
            this.logStatus = query.getLogStatus();
            this.response = query.getResponse();
            return this;
        }

        public Query build(){
            return new Query(this);
        }
    }
}