package com.systemsmart.service;

import com.systemsmart.entity.Facility;
import java.util.Set;

/*@ Author: Luzuko Tshaka  <216007542@mycput.ac.za>
  @ description : Domain Driven Design - Facility service
*/

public interface FacilityService extends IService<Facility,String, A>{

    Set<Facility> getAll();

}
