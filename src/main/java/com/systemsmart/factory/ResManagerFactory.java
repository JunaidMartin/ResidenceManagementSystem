package com.systemsmart.factory;

import com.systemsmart.entity.ResidenceManager;

public class ResManagerFactory {

    public static ResidenceManager resMan(int managerId, String firstName, String lastName){

        ResidenceManager rs = new ResidenceManager.Builder().setManagerId(managerId).setFirstName(firstName).setLastName(lastName).build();

        return rs;
    }
}
