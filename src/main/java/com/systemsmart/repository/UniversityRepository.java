package com.systemsmart.repository;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 28/08/2020*/

import com.systemsmart.entity.Campus;
import com.systemsmart.entity.Student;
import com.systemsmart.entity.University;

import java.util.Set;

public interface UniversityRepository extends IRepository <University, String> {
    Set<University> getAll();
}
