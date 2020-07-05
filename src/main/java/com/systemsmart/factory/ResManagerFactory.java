package com.systemsmart.factory;

import com.systemsmart.entity.ResidenceManager;

/*  Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
    Description: This class instantiates the Residence Manager object
    Date: 05 July 2020
*/

public class ResManagerFactory {

    public static ResidenceManager resMan(int employeeId, String firstName, String lastName, String employmentDate, String residenceName, int accessLevel){

        ResidenceManager rm = new ResidenceManager.Builder().setEmployeeId(employeeId).setFirstName(firstName).setLastName(lastName).setEmploymentDate(employmentDate).setResidenceName(residenceName).setAccessLevel(accessLevel).build();

        return rm;
    }
}
