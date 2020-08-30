package com.systemsmart.repository;

import com.systemsmart.entity.Residence;
import java.util.Set;

public interface ResidenceRepository extends IRepository<Residence, Integer> {
    Set<Residence> getAll();
}
