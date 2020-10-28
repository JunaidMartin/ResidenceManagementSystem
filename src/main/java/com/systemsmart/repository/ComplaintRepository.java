package com.systemsmart.repository;

import com.systemsmart.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, String>{
    //Set<Complaint> retrieve();
    //Set<Complaint> getProcessingComplaints() {
}
