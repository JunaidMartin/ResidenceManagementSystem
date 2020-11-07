package com.systemsmart.controller;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 25/09/2020*/
import com.systemsmart.entity.Address;
import com.systemsmart.entity.Campus;
import com.systemsmart.factory.CampusFactory;
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
public class CampusControllerTest {

    private static Campus campus = CampusFactory.createCampus(216178606, "CPUT District Six Campus");
    private static  String SECURITY_USERNAME = "user";
    private static String SECURITY_PASSWORD ="password";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/campus/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("Post date:" + campus);
        ResponseEntity<Campus> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, campus, Campus.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        campus = postResponse.getBody();
        System.out.println("Saved data:" + campus);
        assertEquals(campus.getCampusId(), postResponse.getBody().getCampusId());
    }

    @Test
    public void d_getall() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + campus.getCampusId();
        System.out.println("URL: " + url);
        ResponseEntity<Campus> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, Campus.class);
        System.out.println(response);
        System.out.println(response.getBody());
        assertEquals(campus.getCampusId(), response.getBody().getCampusId());


    }

    @Test
    public void c_update(){
        Campus updated = new Campus.Builder().copy(campus).setCampusId(216178606).build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post date: " + updated);
        ResponseEntity<Campus> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, updated, Campus.class);
        assertEquals(campus.getCampusId(), response.getBody().getCampusId());
    }
    @Test
    public void e_delete() {
        String url = baseURL + "delete/" +campus.getCampusId();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }
}