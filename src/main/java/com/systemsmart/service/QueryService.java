package com.systemsmart.service;

import com.systemsmart.entity.Query;

import java.util.Set;

public interface QueryService extends IService <Query, String>{
    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Description: This is the query service interface
     * Date: 03 September 2020
     */
    void addResponse();
    Set<Query> retrieve();

}
