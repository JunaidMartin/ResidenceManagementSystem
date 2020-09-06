package com.systemsmart.service;

import com.systemsmart.entity.Complaint;

import java.util.Set;

public interface ComplaintService extends IService <Complaint, String, R>{
    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Description: This is the complaint service interface
     * Date: 03 September 2020
     */

    Set<Complaint> retrieve();
}
