package com.systemsmart.entity;

//  Author:  Inga Mzileni <216279631@mycput.ac.za>

public class Address {
    private String street, suburb, city ;
    private int postalCode;

    public Address(Builder builder){
        this.street = builder.street;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public Address() {

    }

    public String getStreet() {
        return street;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static class Builder{
        private String street;
        private String suburb;
        private String city;
        private int postalCode;

        public Builder setStreet(String street){
            this.street = street;
            return this;
        }
        public Builder setSuburb(String suburb){
            this.suburb = suburb;
            return this;
        }
        public Builder setCity(String city){
            this.city = city;
            return this;
        }
        public Builder setPostel(int postalCode){
            this.postalCode = postalCode;
            return this;
        }

        public  Builder copy(Address address){
            this.street = address.street;
            this.suburb = address.suburb;
            this.city = address.city;
            this.postalCode = address.postalCode;
            return this;
        }

        public Address build(){
            return new Address(this);
        }


    }
}
