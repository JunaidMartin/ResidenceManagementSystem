package com.systemsmart.service.impl;

import com.systemsmart.entity.StudentApplication;
import com.systemsmart.repository.StudentApplicationRepository;
import com.systemsmart.service.StudentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

/*
    Author: Brandon Charles 218220065@mycput.ac.za
    Date:  13 November 2020
 */

@Service
public class StudentApplicationServiceImpl implements StudentApplicationService {

    @Autowired
    private StudentApplicationRepository repository = null;

    @Override
    public StudentApplication create(StudentApplication t) {
        return this.repository.save(t);
    }

    @Override
    public StudentApplication read(Integer s) {
        return repository.findById(s).orElseGet(null);
    }

    @Override
    public StudentApplication update(StudentApplication t) {
        return this.repository.save(t);
    }

    @Override
    public boolean delete(Integer s) {
        repository.deleteById(s);
        return !repository.existsById(s);
    }

    @Override
    public Set<StudentApplication> getAll() {
        return new HashSet<>(this.repository.findAll());
    }
}
