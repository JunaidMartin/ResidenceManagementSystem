package com.systemsmart.service;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 05/07/2020*/

import com.systemsmart.entity.University;
import java.util.Set;

public interface UniversityService extends IService <University, String, R> {
    Set<University> getAll();
    // unique business logic as per student.
    Set<University> getUniversityWithUniversityNameCPUT();
}