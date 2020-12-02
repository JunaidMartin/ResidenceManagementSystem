package com.systemsmart.service.impl;

import com.systemsmart.entity.Query;
import com.systemsmart.repository.QueryRepository;
import com.systemsmart.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/*
 * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
 * Description: This class implements the Query service interface methods
 * Date: 03 September 2020
 */

@Service
public class QueryServiceImpl implements QueryService {


    private static QueryService service = null;
    @Autowired
    private QueryRepository repository;


    @Override
    public Query create(Query query) {
        Query newQuery = new Query.Builder().copy(query).setLogStatus("Processing").build();
        return this.repository.save(newQuery);
    }

    @Override
    public Query read(String queryId) {
        return repository.findById(queryId).orElseGet(null);
    }

    @Override
    public Query update(Query query) {

        if (this.repository.existsById(query.getQueryId())){
            return this.repository.save(query);
        }
        return null;
    }

    @Override
    public boolean delete(String queryId) {
        repository.deleteById(queryId);
        return !repository.existsById(queryId);
    }

    @Override
    public void addResponse() {

    }

    @Override
    public Set<Query> retrieve() { return this.repository.findAll().stream().collect(Collectors.toSet());
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

