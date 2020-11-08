package com.systemsmart.controller;

import com.systemsmart.entity.Address;
import com.systemsmart.factory.AddressFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressControllerTest {

    private static Address address = AddressFactory.createAddress("012345", "2591", "Msenge","Philippi","Cape Town","7758");
    private static String SECURITY_USERNAME = "student";
    private static String SECURITY_PASSWORD = "stud123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/systemsmart/address/";

    @Test
    public void a_create() {
        Address address = AddressFactory.createAddress("012345","2591", "Msenge", "Philippi", "Cape Town","7758");
        String url = baseURL + "create";
        ResponseEntity<Address> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, address, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse);
       // assertEquals(HttpStatus.FORBIDDEN, postResponse.getStatusCode());
        System.out.println(postResponse.getBody().getAddressId());
    }

    @Test

    public void d_getAll() {
        String url = baseURL + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
        .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test

    public void b_read() {
        String url = baseURL + "read/" + address.getAddressId();
        System.out.println("URL: " + url);
        ResponseEntity<Address> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
        .getForEntity(url, Address.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test

    public void c_update() {
        Address updated = new Address.Builder().copy(address).setAddressId("0123456").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post date: " + updated);
        ResponseEntity<Address> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, updated, Address.class);
             address = response.getBody();
        // assertEquals(address.getAddressId(), response.getBody().getAddressId());


    }

    @Test
    @Ignore
    public void e_delete() {
        String iD = "";
        String url = baseURL + "delete/" + address.getAddressId();
        System.out.println("URL: " + url);
        url = baseURL + "delete/" + iD;
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }
}