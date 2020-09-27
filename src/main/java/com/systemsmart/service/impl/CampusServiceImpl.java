package com.systemsmart.service.impl;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 05/07/2020*/

import com.systemsmart.entity.Campus;
import com.systemsmart.repository.CampusRepository;
import com.systemsmart.repository.impl.CampusRepositoryImpl;
import com.systemsmart.service.CampusService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CampusServiceImpl implements CampusService {
    private static CampusService service = null;
    private CampusRepository repository;

    private CampusServiceImpl(){
        this.repository = CampusRepositoryImpl.getRepository();
    }

    public static CampusService getService(){
        if (service == null) service = new CampusServiceImpl();
        return service;
    }

    @Override
    public Set<Campus> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Set<Campus> getCampusesWithCampusID217() {
        Set<Campus> campuses = getAll();
        Set<Campus> campusWith217 = new HashSet<>();
        for (Campus campus : campuses) {
            if (campus.getCampusId() == 217){
                campusWith217.add(campus);
            }
        }
        return campusWith217;
    }

    @Override
    public Campus create(Campus campus) {
        return this.repository.create(campus);
    }

    @Override
    public Campus read(String c) {
        return this.repository.read(c);
    }

    @Override
    public Campus update(Campus campus) {
        return this.repository.update(campus);
    }

    @Override
    public boolean delete(String c) {
        return this.repository.delete(c);
    }
}
