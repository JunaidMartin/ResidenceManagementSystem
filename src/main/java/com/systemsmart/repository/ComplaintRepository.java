package com.systemsmart.repository;

import com.systemsmart.entity.Complaint;

import java.util.Set;

public interface ComplaintRepository extends IRepository<Complaint, String>{
    Set<Complaint> retrieve();
}
