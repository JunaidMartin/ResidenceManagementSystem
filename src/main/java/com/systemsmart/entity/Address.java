package com.systemsmart.entity;

//  Author:  Inga Mzileni <216279631@mycput.ac.za>

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Address implements Serializable {

    @Id
    private String addressId;
    private String streetNum;
    private String streetName;
    private String suburb;
    private String city;
    private String postalCode;

    protected Address() {
    }

    public Address(Builder builder) {
        this.addressId = builder.addressId;
        this.streetNum = builder.streetNum;
        this.streetName = builder.streetName;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId + '\'' +
                "streetNum='" + streetNum + '\'' +
                "streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static class Builder {
        private String addressId;
        private String streetNum;
        private String streetName;
        private String suburb;
        private String city;
        private String postalCode;


        public Builder setAddressId(String addressId) {
            this.addressId = addressId;
            return this;

        }

        public Builder setStreetNum(String streetNum) {
            this.streetNum = streetNum;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPostal(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy(Address address) {
            this.addressId = address.addressId;
            this.streetNum = address.streetNum;
            this.streetName = address.streetName;
            this.suburb = address.suburb;
            this.city = address.city;
            this.postalCode = address.postalCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId.equals(address.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId);
    }
}