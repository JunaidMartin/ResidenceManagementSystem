package com.systemsmart.repository;

import com.systemsmart.entity.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ResidenceRepository extends JpaRepository<Residence, Integer> { }
