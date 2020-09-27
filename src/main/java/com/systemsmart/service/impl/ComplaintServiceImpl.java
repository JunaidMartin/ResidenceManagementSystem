package com.systemsmart.service.impl;

import com.systemsmart.entity.Complaint;
import com.systemsmart.repository.ComplaintRepository;
import com.systemsmart.repository.impl.ComplaintRepositoryImpl;
import com.systemsmart.service.ComplaintService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Description: This class implements the Complaint service interface methods
     * Date: 03 September 2020
     */

    private static ComplaintService service = null;
    private ComplaintRepository repository;

    private ComplaintServiceImpl(){

        this.repository = ComplaintRepositoryImpl.getRepository();
    }

    public static ComplaintService getService(){
        if (service == null) service = new ComplaintServiceImpl();
        return service;
    }
    @Override
    public Complaint create(Complaint c) {
        return this.repository.create(c);
    }

    @Override
    public Complaint read(String r) {
        return this.repository.read(r);
    }

    @Override
    public Complaint update(Complaint u) {
        return this.repository.update(u);
    }

    @Override
    public boolean delete(String d) {
        return this.repository.delete(d);
    }


    @Override
    public Set<Complaint> retrieve() {
        return this.repository.retrieve();
    }
}

