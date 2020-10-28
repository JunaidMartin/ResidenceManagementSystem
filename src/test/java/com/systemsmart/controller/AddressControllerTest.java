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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressControllerTest {

    private static Address address = AddressFactory.createAddress("2591 Msenge Street", "Philippi", "Cape Town",7785);

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/address/";

    @Test
    public void a_create() {
        Address address = AddressFactory.createAddress("2591 Msenge Street","Philippi", "Cape Town", 7785);
        String url = baseURL + "create";
        ResponseEntity<Address> postResponse = restTemplate.postForEntity(url, address, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test

    public void d_getAll() {
        String url = baseURL + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test

    public void b_read() {
        String url = baseURL + "read/" + address.getStreet();
        System.out.println("URL: " + url);
        ResponseEntity<Address> response = restTemplate.getForEntity(url, Address.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test

    public void c_update() {
        Address updated = new Address.Builder().copy(address).setStreet("5050 Kapa Street").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post date: " + updated);
        ResponseEntity<Address> response = restTemplate.postForEntity(url, updated, Address.class);
        address = response.getBody();
        assertEquals(address.getStreet(), response.getBody().getStreet());
    }

    @Test

    public void f_delete() {
        String url = baseURL + "delete/" + address.getStreet();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}