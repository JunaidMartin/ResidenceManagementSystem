package com.systemsmart.controller;

import com.systemsmart.entity.Query;
import com.systemsmart.factory.QueryFactory;
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

import java.util.UUID;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QueryControllerTest extends TestCase {

    /*
     * Author: Christ Kitenge Mbuyi <217248756@mycput.ac.za>
     * Date: 23 September 2020
     */

    private static Query query = QueryFactory.createQuery(UUID.randomUUID().toString(), "Complaint", "Junaid Martin", "216178606","Whatever", "Processing", "Hi, I will sort the problem out by this coming Wednesday. Thanks");

    private static String SECURITY_USERNAME = "admin";
    private static String SECURITY_PASSWORD = "admin123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/query/";

    @Test
    public void a_create() {
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
    public void b_read() {
        String url = baseURL + query.getQueryId();
        ResponseEntity<Query> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, Query.class);
        System.out.println("STATUS CODE: " + response.getStatusCode());
        System.out.println("BODY: " + response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(query.getQueryId(), response.getBody().getQueryId());
    }
    @Test
    public void c_update() {

        Query qry = new Query.Builder().copy(query).setDescription("Description has been changed").build();
        String url = baseURL + "update";
        ResponseEntity<Query> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, qry, Query.class);
        System.out.println("STATUS CODE: " + response.getStatusCode());
        System.out.println("BODY: " + response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(query.getQueryId(), response.getBody().getQueryId());
    }

    @Test
    public void d_getAll() {
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
    public void e_delete() {
        String url = baseURL + "delete/" + query.getQueryId();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).exchange(url, HttpMethod.DELETE, entity, String.class);
        System.out.println("STATUS CODE: " + response.getStatusCode());
        System.out.println("BODY: " + response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(true, Boolean.parseBoolean(response.getBody()));
    }
}