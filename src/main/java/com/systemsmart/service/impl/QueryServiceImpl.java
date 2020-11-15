package com.systemsmart.service.impl;

import com.systemsmart.entity.Query;
import com.systemsmart.repository.QueryRepository;
import com.systemsmart.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QueryServiceImpl implements QueryService {

    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Description: This class implements the Complaint service interface methods
     * Date: 03 September 2020
     */

    private static QueryService service = null;
    @Autowired
    private QueryRepository repository;

    @Override
    public Query create(Query c) {
        Query newQuery = new Query.Builder().copy(c).setLogStatus("Processing").build();
        return this.repository.save(newQuery);
    }

    @Override
    public Query read(String r) {
        return this.repository.findById(r).orElseGet(null);
    }

    @Override
    public Query update(Query u) {

        if (this.repository.existsById(u.getQueryId())){
            return this.repository.save(u);
        }
        return null;
    }

    @Override
    public boolean delete(String d) {

        this.repository.deleteById(d);
        if (this.repository.existsById(d)) return false;
        else return true;
    }

    @Override
    public void addResponse() {

    }

    @Override
    public Set<Query> retrieve() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


//        @Override
//    public Set<Complaint> getProcessingComplaints() {
//        Set<Complaint> complaints = retrieve();
//        Set<Complaint> processingComplaint = new HashSet<>();
//        for (Complaint complaint : complaints) {
//            if (complaint.getLogStatus().trim().equalsIgnoreCase("processing")){
//                processingComplaint.add(complaint);
//            }
//        }
//        return processingComplaint;
//    }
}

