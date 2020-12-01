package com.systemsmart.repository;

import com.systemsmart.entity.ResidenceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ResManagerRepository extends JpaRepository<ResidenceManager, Integer> {
   // Set<ResidenceManager> retrieve();
}
