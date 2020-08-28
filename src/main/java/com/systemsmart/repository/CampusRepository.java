package com.systemsmart.repository;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 28/08/2020*/

import com.systemsmart.entity.Campus;
import com.systemsmart.entity.Student;

import java.util.Set;

public interface CampusRepository extends IRepository <Campus, String> {
    Set<Campus> getAll();
}
