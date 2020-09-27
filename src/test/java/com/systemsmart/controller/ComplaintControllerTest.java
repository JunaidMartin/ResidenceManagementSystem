package com.systemsmart.controller;

import com.systemsmart.entity.Complaint;
import com.systemsmart.factory.ComplaintFactory;
import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComplaintControllerTest extends TestCase {

    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Date: 23 September 2020
     */

    private static Complaint complaint = ComplaintFactory.logComplaint(2211, "The room i've booked is not the same as the one i see on the system", "processing");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/complaint/";

    @Test
    public void testCreate() {
        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("Post date:" + complaint);
        ResponseEntity<Complaint> postResponse = restTemplate.postForEntity(url, complaint, Complaint.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        complaint = postResponse.getBody();
        System.out.println("Saved data:" + complaint);
        assertEquals(complaint.getComplaintID(), postResponse.getBody().getComplaintID());
    }

    @Test
    public void testRead() {
        String url = baseURL + "read/" + complaint.getLogStatus();
        System.out.println("URL: " + url);
        ResponseEntity<Complaint> response = restTemplate.getForEntity(url, Complaint.class);
        assertEquals(complaint.getLogStatus(), response.getBody().getLogStatus());
    }
    @Test
    public void testUpdate() {
        Complaint updated = new Complaint.Builder().copy(complaint).setComplaintID(2200).build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Previous ID: " + complaint.getComplaintID());
        System.out.println("New ID: " + updated.getComplaintID());
        ResponseEntity<Complaint> response = restTemplate.postForEntity(url, updated, Complaint.class);
        assertEquals(updated.getComplaintID(), response.getBody().getComplaintID());
    }

    @Test
    public void testGetall() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void testDelete() {
        String url = baseURL + "delete/" +complaint.getComplaintID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}