package com.systemsmart.repository;

import com.systemsmart.entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends JpaRepository<Query, String>{
    //Set<Complaint> retrieve();
    //Set<Complaint> getProcessingComplaints() {
}
