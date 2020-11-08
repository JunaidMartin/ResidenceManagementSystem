package com.systemsmart.controller;
/*Author: @Phumelela Hoho
* <212195131@mycput.ac.za>
Description: Domain class description
* Date: 25/09/2020*/

import com.systemsmart.entity.Campus;
import com.systemsmart.entity.University;
import com.systemsmart.factory.UniversityFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
public class UniversityControllerTest {

    private static University university = UniversityFactory.createUniversity("CPUT");
    private static String SECURITY_USERNAME = "admin";
    private static String SECURITY_PASSWORD = "admin123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/university/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("Post date:" + university);
        ResponseEntity<University> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, university, University.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        university = postResponse.getBody();
        System.out.println("Saved data:" + university);
        assertEquals(university.getUniversityName(), postResponse.getBody().getUniversityName());
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
        String url = baseURL + "read/" + university.getUniversityName();
        System.out.println("URL: " + url);
        ResponseEntity<University> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, University.class);
        System.out.println(response);
        System.out.println(response.getBody());
        //assertEquals(university.getUniversityName(), response.getBody().getUniversityName());

    }

    @Test
    public void c_update(){
        University updated = new University.Builder().copy(university).setUniversityName("CPUT").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post date: " + updated);
        ResponseEntity<University> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, updated, University.class);
        //assertEquals(university.getUniversityName(), response.getBody().getUniversityName());
    }
    @Test
    @Ignore
    public void e_delete() {
        String url = baseURL + "delete/" +university.getUniversityName();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).delete(url);
    }
}