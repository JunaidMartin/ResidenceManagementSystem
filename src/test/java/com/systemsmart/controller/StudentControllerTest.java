package com.systemsmart.controller;

import com.systemsmart.entity.Student;
import com.systemsmart.factory.StudentFactory;
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
public class StudentControllerTest {

    private static Student student = StudentFactory.buildStudent("123456789", "Yusrahhh", "Essop",
            "CPUT District Six Campus", 1023456789123L, "123456789@mycput.ac.za", "0123456789");
    private static String SECURITY_USERNAME = "student";
    private static String SECURITY_PASSWORD = "student123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/student/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("Post date:" + student);
        ResponseEntity<Student> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, student, Student.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        student = postResponse.getBody();
        System.out.println("Saved data:" + student);
        assertEquals(student.getStudNum(), postResponse.getBody().getStudNum());
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
        String url = baseURL + "read/" + student.getStudNum();
        System.out.println("URL: " + url);
        ResponseEntity<Student> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, Student.class);
        assertEquals(student.getStudNum(), response.getBody().getStudNum());
    }

    @Test
    public void c_update(){
        Student updated = new Student.Builder().copy(student).setContactNum("0798149723").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post date: " + updated);
        ResponseEntity<Student> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, updated, Student.class);
        assertEquals(student.getStudNum(), response.getBody().getStudNum());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + student.getStudNum();
        System.out.println("URL: " + url);
        System.out.println();
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }
}
