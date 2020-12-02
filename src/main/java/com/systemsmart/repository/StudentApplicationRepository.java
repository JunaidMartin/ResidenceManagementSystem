package com.systemsmart.repository;

import com.systemsmart.entity.StudentApplication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentApplicationRepository extends JpaRepository<StudentApplication, String> {

}
