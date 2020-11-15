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

    //create
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Query create(@RequestBody Query c){
        Query query = QueryFactory.logQuery(c.getNature(), c.getDescription(), c.getLogStatus(), c.getResponse());
        return service.create(query);
    }

    //read
    @GetMapping("/read/{id}")
    public Query read(@PathVariable String id){
        return service.read(id);
    }

    //update
    @PostMapping ("/update")
    public Query update(@RequestBody Query query){
        return service.update(query);
    }

    //getAll
    @GetMapping("/all")
    public Set<Query> getall(){
        return service.retrieve();
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }
}
