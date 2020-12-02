package com.systemsmart.controller;

import com.systemsmart.entity.Query;
import com.systemsmart.factory.QueryFactory;
import com.systemsmart.service.impl.QueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/query")
public class QueryController {

    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Date: 23 September 2020
     */

    @Autowired
    private QueryServiceImpl service;

    @PostMapping("/create")
    public Query createQuery(@RequestBody Query query){
        Query newQuery = QueryFactory.createQuery(query.getQueryId(), query.getNature(), query.getFullName(), query.getStudNum(), query.getDescription(), query.getLogStatus(), query.getResponse());
        return service.create(newQuery);
    }
    @PostMapping("/update")
    public Query updateQuery(@RequestBody Query query){ return service.update(query);}
    @GetMapping("/read/{id}")
    public Query getQuery(@PathVariable String id){
        return service.read(id);
    }
    @GetMapping("/all")
    public Set<Query> retrieve(){return service.retrieve();}
    @DeleteMapping("/delete/{id}")
    public  boolean delete(@PathVariable String id){
        return service.delete(id);
    }
}
