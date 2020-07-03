package com.systemsmart.entity;

public abstract class UserType {
    private Boolean isGuest;
    private long userID;
    private String firstName;
    private String lastName;

    public UserType(){
    }
    public UserType(Builder builder) {
        this.isGuest = builder.isGuest;
        this.userID = builder.userID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    //Getters
    public Boolean getGuest() {
        return isGuest;
    }

    public long getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //toString
    @Override
    public String toString() {
        return "User{" +
                "userID : " + userID +
                ", First Name : '" + firstName + '\'' +
                ", Last Name : '" + lastName + '\'' +
                '}';
    }

    // Builder Class
    public static abstract class Builder {
        private boolean isGuest;
        private long userID;
        private String firstName;
        private String lastName;

        public Builder setGuest(boolean guest) {
            isGuest = guest;
            return this;
        }

        public Builder setUserID(long userID) {
            this.userID = userID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder copy(UserType userType) {
            this.userID = userType.userID;
            this.firstName = userType.firstName;
            this.lastName = userType.lastName;
            return this;
        }

        public abstract UserType build();

    }
}
