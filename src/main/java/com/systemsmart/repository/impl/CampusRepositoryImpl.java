package com.systemsmart.repository.impl;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 28/08/2020*/

import com.systemsmart.entity.Campus;
import com.systemsmart.entity.Student;
import com.systemsmart.repository.CampusRepository;
import com.systemsmart.repository.StudentRepository;

import java.util.HashSet;
import java.util.Set;

public class CampusRepositoryImpl implements CampusRepository {
    private static CampusRepository repository = null;
    private Set<Campus> campusDB;

    private CampusRepositoryImpl() {this.campusDB = new HashSet<>();}

    public static CampusRepository getRepository(){
        if (repository == null) repository =  new CampusRepositoryImpl();
        return repository;
    }


    public Campus create(Campus campus) {
        this.campusDB.add(campus);
        return campus;
    }

    @Override
    public Campus read(String s) {
        return null;
    }


    public Campus read(int campusId) {
//        Campus campus = this.campusDB.stream().filter(s -> s.getCampusId().trim().equalsIgnoreCase(campusId)).findAny().orElse(null);

        for (Campus campus : this.campusDB){
            if (campus.getCampusId()==(campusId));
            return campus;
        }
        return null;
    }


    public Campus update(Campus campus) {
        boolean deleteCampus = delete(campus.getCampusId());
        if (deleteCampus){
            this.campusDB.add(campus);
            return campus;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }


    public boolean delete(int campusId) {
        Campus campus = read(campusId);
        if (campus != null){
            this.campusDB.remove(campus);
            return true;
        }
        return false;
    }


    public Set<Campus> getAll() {
        return this.campusDB;
    }
}
