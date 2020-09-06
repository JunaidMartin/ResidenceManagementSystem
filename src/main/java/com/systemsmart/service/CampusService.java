package com.systemsmart.service;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 05/07/2020*/

import com.systemsmart.entity.Campus;
import java.util.Set;

public interface CampusService<R> extends IService <Campus, String, R> {
    Set<Campus> getAll();
    // unique business logic as per student.
    Set<Campus> getCampusesWithCampusID217();
}