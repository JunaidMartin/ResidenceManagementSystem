package com.systemsmart.repository;

import com.systemsmart.entity.Facility;
import java.util.Set;

public interface FacilityRepository extends IRepository<Facility, String> {

    Set<Facility> getAll();
}
