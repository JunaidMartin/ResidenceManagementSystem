package com.systemsmart.service;

import com.systemsmart.entity.StudentApplication;
import java.util.Set;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Date:  13 November 2020
 */


public interface StudentApplicationService extends IService<StudentApplication, Integer>{
    Set<StudentApplication> getAll();
}
