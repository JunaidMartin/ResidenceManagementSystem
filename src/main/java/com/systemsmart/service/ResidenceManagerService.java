package com.systemsmart.service;

import com.systemsmart.entity.ResidenceManager;

import java.util.Set;

public interface ResidenceManagerService extends IService <ResidenceManager, String>{

    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Description: This is the ResidenceManager service interface
     * Date: 03 September 2020
     */

    Set<ResidenceManager> retrieve();
}
