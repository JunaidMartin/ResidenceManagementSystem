package com.systemsmart.repository;

import com.systemsmart.entity.Address;
import com.systemsmart.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AddressRepository extends JpaRepository<Address, String>{

}
