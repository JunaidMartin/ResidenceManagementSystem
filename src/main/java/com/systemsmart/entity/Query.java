package com.systemsmart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/*  Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
    Description: This class specifies the attributes of the Complaint entity using builder pattern
    Date: 05 July 2020
*/
@Entity
public class Query implements Serializable {
    @Id
    private String queryId;
    private String nature;
    private String description;
    private String logStatus;
    private String response;

    //constructor
    protected Query(){}

    public Query(Builder builder) {
        this.queryId = builder.queryId;
        this.nature = builder.nature;
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
                ", description='" + description + '\'' +
                ", logStatus='" + logStatus + '\'' +
                ", response='" + response + '\'' +
                '}';
    }

    //Builder
    public static class Builder{
        private String queryId;
        private String nature;
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

        public Builder copy(Query c){

            this.queryId = c.queryId;
            this.nature = c.nature;
            this.description = c.description;
            this.logStatus = c.logStatus;
            this.response = c.response;

            return this;
        }

        public Query build(){
            return new Query(this);
        }
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
}
