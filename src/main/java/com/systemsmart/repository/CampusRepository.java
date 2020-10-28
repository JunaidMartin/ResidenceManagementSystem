package com.systemsmart.repository;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 28/08/2020*/

import com.systemsmart.entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CampusRepository extends JpaRepository<Campus, String> {
}
