package com.systemsmart.repository;

import com.systemsmart.entity.ResidenceManager;

import java.util.Set;

public interface ResManagerRepository extends IRepository<ResidenceManager, String> {
    Set<ResidenceManager> retrieve();
}
