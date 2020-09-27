package com.systemsmart.service.impl;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 05/07/2020*/

import com.systemsmart.entity.University;
import com.systemsmart.repository.UniversityRepository;
import com.systemsmart.repository.impl.UniversityRepositoryImpl;
import com.systemsmart.service.UniversityService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UniversityServiceImpl implements UniversityService {
    private static UniversityService service = null;
    private UniversityRepository repository;

    private UniversityServiceImpl(){
        this.repository = UniversityRepositoryImpl.getRepository();
    }

    public static UniversityService getService(){
        if (service == null) service = new UniversityServiceImpl();
        return service;
    }

    @Override
    public Set<University> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Set<University> getUniversityWithUniversityNameCPUT() {
        Set<University> universities = getAll();
        Set<University> universitiesWithCPUT = new HashSet<>();
        for (University university : universities) {
            if (university.getUniversityName().trim().startsWith("CPUT")){
                universitiesWithCPUT.add(university);
            }
        }
        return universitiesWithCPUT;
    }

    @Override
    public University create(University university) {
        return this.repository.create(university);
    }

    @Override
    public University read(String u) {
        return this.repository.read(u);
    }

    @Override
    public University update(University university) {
        return this.repository.update(university);
    }

    @Override
    public boolean delete(String u) {
        return this.repository.delete(u);
    }
}
