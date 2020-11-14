package com.systemsmart.service.impl;

import com.systemsmart.entity.Complaint;
import com.systemsmart.repository.ComplaintRepository;
import com.systemsmart.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Description: This class implements the Complaint service interface methods
     * Date: 03 September 2020
     */

    private static ComplaintService service = null;
    @Autowired
    private ComplaintRepository repository;

    @Override
    public Complaint create(Complaint c) {
        return this.repository.save(c);
    }

    @Override
    public Complaint read(String r) {
        return this.repository.findById(r).orElseGet(null);
    }

    @Override
    public Complaint update(Complaint u) {

        if (this.repository.existsById(u.getLogStatus())){
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
    public Set<Complaint> retrieve() {
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

