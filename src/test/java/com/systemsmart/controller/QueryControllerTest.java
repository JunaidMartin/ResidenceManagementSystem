package com.systemsmart.controller;

import com.systemsmart.entity.Query;
import com.systemsmart.factory.QueryFactory;
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
public class QueryControllerTest extends TestCase {

    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Date: 23 September 2020
     */

    private static Query query = QueryFactory.logQuery("Complaint", "There is a leak in the ceiling.", "", "");

    private static String SECURITY_USERNAME = "admin";
    private static String SECURITY_PASSWORD = "admin123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/complaint/";

    @Test
    public void testCreate() {
        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("Post date:" + query);
        if (query.getLogStatus().equals(null)) {
            query = new Query.Builder().copy(query).setLogStatus("Processing").build();
        }
        if (query.getNature().equals(null)) {
            query = new Query.Builder().copy(query).setNature("Complaint").build();
        }
        query = new Query.Builder().copy(query).setNature("Complaint").setLogStatus("Processing").build();
        System.out.println(query.toString());
        ResponseEntity<Query> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, query, Query.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        query = postResponse.getBody();
        System.out.println("Saved data:" + query);
        assertEquals(query.getQueryId(), postResponse.getBody().getQueryId());
    }

    @Test
    public void testRead() {
        String url = baseURL + "read/" + query.getQueryId();
        System.out.println("URL: " + url);
        ResponseEntity<Query> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, Query.class);

    }
    @Test
    public void testUpdate() {
        Query updated = new Query.Builder().copy(query).setQueryId("2200").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Previous ID: " + query.getQueryId());
        System.out.println("New ID: " + updated.getQueryId());
        ResponseEntity<Query> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, updated, Query.class);

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
    }

    @Test
    public void testDelete() {
        String url = baseURL + "delete/" + query.getQueryId();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }
}