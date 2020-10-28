//package com.systemsmart.repository.impl;
//
//import com.systemsmart.entity.Complaint;
//import com.systemsmart.repository.ComplaintRepository;
//import java.util.HashSet;
//import java.util.Set;
//
//public class ComplaintRepositoryImpl implements ComplaintRepository{
//    private Set<Complaint> complaintSet;
//    private static ComplaintRepository repository = null;
//
//
//    public static ComplaintRepository getRepository(){
//        if (repository == null) repository = new ComplaintRepositoryImpl();
//        return repository;
//    }
//
//    public ComplaintRepositoryImpl() {
//        this.complaintSet = new HashSet<>();
//    }
//
//    @Override
//    public Complaint create(Complaint c) {
//       this.complaintSet.add(c);
//       return c;
//    }
//
//
//    @Override
//    public Complaint read(String logStatus){
//        for(Complaint c : this.complaintSet){
//            if(c.getLogStatus().equalsIgnoreCase(logStatus)) return c;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String logStatus){
//        Complaint c = read(logStatus);
//        if(c != null) this.complaintSet.remove(c);
//        return true;
//    }
//
//    @Override
//    public Complaint update(Complaint complaint) {
//        boolean deleteComplaint = delete(complaint.getLogStatus());
//            if (deleteComplaint){
//                this.complaintSet.add(complaint);
//                return complaint;
//        }
//                return null;
//    }
//
//    @Override
//    public Set<Complaint> retrieve() {
//        return this.complaintSet;
//    }
//}
//
//
