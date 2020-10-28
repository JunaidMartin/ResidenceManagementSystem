//package com.systemsmart.service.impl;
//
//import com.systemsmart.entity.Complaint;
//import com.systemsmart.factory.ComplaintFactory;
//import com.systemsmart.service.ComplaintService;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class ComplaintServiceImplTest {
//
//    /*
//     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
//     * Description: This class tests the Complaint service interface methods
//     * Date: 03 September 2020
//     */
//
//    private static ComplaintService service = ComplaintServiceImpl.getService();
//    private static Complaint complaint = ComplaintFactory.logComplaint(2211, "The room i've booked is not the same as the one i see on the system", "processing");
//
//    @Test
//    public void create() {
//        Complaint newComplaint = service.create(complaint);
//        Assert.assertEquals(complaint.getComplaintID(), newComplaint.getComplaintID());
//        System.out.println ("Created: " + newComplaint);
//    }
//
//    @Test
//    public void read() {
//        Complaint read = service.read(complaint.getLogStatus());
//    }
//
//    @Test
//    public void c_update() {
//        Complaint updated = new Complaint.Builder().copy(complaint).setComplaintID(2200).build();
//        updated = service.update(updated);
//        System.out.println("Updated: " + updated);
//
//    }
//
//    @Test
//    public void e_delete() {
//        boolean deleted = service.delete(complaint.getLogStatus());
//        Assert.assertTrue(deleted);
//        System.out.println("Deleted: " + deleted);
//    }
//
//    @Test
//    public void retrieve() {
//        System.out.println("List: " + service.retrieve());
//    }
//}
