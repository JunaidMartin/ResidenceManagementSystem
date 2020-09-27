package com.systemsmart.controller;

/*@ Author: Luzuko Tshaka  <216007542@mycput.ac.za>
  @ description : Domain Driven Design - Facility  controllers
*/

import com.systemsmart.entity.Facility;
import com.systemsmart.entity.Room;
import com.systemsmart.factory.FacilityFactory;
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

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FacilityControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/facility/";
    private static  Facility facility = FacilityFactory.createFacility("234555",true,true,true,
            true,true,true,true,"pre-paid electricity meter");;

    @Test
    public void a_create() {

        String url = baseURL + "create";
        System.out.println(url);
        ResponseEntity<Facility> postResponse = restTemplate.postForEntity(url,facility,Facility.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println("Created create "+postResponse.getBody());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Get All "+response.getBody());

    }

    @Test
    public void b_read() {

        String url = baseURL + "read/" + facility.getFacilityId();
        System.out.println("URL: " + url);
        ResponseEntity<Facility> response = restTemplate.getForEntity(url, Facility.class);
        System.out.println("Read "+response.getBody());

    }

    @Test
    public void c_update() {

        Facility facilityUpdated = new Facility.Builder().copy(facility).setUniversityTransport(false).build();
        String url = baseURL + "update";
        System.out.println("URL: "+ url);
        System.out.println("Post data: "+ facilityUpdated);
        ResponseEntity<Facility> response = restTemplate.postForEntity(url, facilityUpdated, Facility.class);
        facility = response.getBody();
        System.out.println("Updated data: "+ response.getBody());
        assertEquals(facility.getFacilityId(),response.getBody().getFacilityId());
    }

    @Test
    public void e_delete() {

        String url = baseURL + "delete/" + facility.getFacilityId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}