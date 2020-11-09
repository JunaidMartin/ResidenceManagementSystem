package com.systemsmart.controller;


import com.systemsmart.entity.ResidenceManager;
import com.systemsmart.factory.ResManagerFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResidenceManagerControllerTest extends TestCase {

    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Date: 23 September 2020
     */
    private static ResidenceManager residenceManager = ResManagerFactory.resMan(217248756, "Joel", "Kutino", "10 March 2020", "Blouberg", 8);

    private static String SECURITY_USERNAME = "admin";
    private static String SECURITY_PASSWORD = "admin123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/manager/";

    @Test
    public void testCreate() {
        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("Post date:" + residenceManager);
        ResponseEntity<ResidenceManager> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, residenceManager, ResidenceManager.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        residenceManager = postResponse.getBody();
        System.out.println("Saved data:" + residenceManager);
        assertEquals(residenceManager.getFirstName(), postResponse.getBody().getFirstName());
    }

    @Test
    public void testRead() {
        String url = baseURL + "read/" + residenceManager.getFirstName();
        System.out.println("URL: " + url);
        ResponseEntity<ResidenceManager> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, ResidenceManager.class);
}


    @Test
    public void testUpdate() {
        ResidenceManager updated = new ResidenceManager.Builder().copy(residenceManager).setLastName("Jessy").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Previous last name: " + residenceManager.getLastName());
        System.out.println("New Last name: " + updated.getLastName());
        ResponseEntity<ResidenceManager> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, updated, ResidenceManager.class);
    }

    @Test
    public void testGetall() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testDelete() {
        String url = baseURL + "delete/" +residenceManager.getAccessLevel();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }
}