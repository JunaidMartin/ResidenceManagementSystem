package com.systemsmart.service;

import com.systemsmart.entity.Facility;
import java.util.Set;

public interface FacilityService extends IService<Facility,String>{

    Set<Facility> getAll();

}
