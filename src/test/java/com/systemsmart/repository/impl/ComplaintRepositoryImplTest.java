package com.systemsmart.repository.impl;

import com.systemsmart.entity.Complaint;


import com.systemsmart.factory.ComplaintFactory;
import com.systemsmart.repository.ComplaintRepository;
import org.junit.Assert;
import org.junit.Test;



public class ComplaintRepositoryImplTest {
    private static ComplaintRepository repository = ComplaintRepositoryImpl.getRepository();

    private static Complaint complaint = ComplaintFactory.logComplaint(2211, "The room i've booked is not the same as the one i see on the system", "processing");


    @Test
    public void create() {
        Complaint newComplaint = repository.create(complaint);
        Assert.assertEquals(complaint.getComplaintID(), newComplaint.getComplaintID());
        System.out.println ("Created: " + newComplaint);
    }

    @Test
    public void read() {
        Complaint read = repository.read(complaint.getLogStatus());
    }

    @Test
    public void c_update() {
        Complaint updated = new Complaint.Builder().copy(complaint).setComplaintID(2200).build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);

    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(complaint.getLogStatus());
        Assert.assertTrue(deleted);
    }

    @Test
    public void retrieve() {
        System.out.println("List: " + repository.retrieve());
    }
}

