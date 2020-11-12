package com.systemsmart.controller;

import com.systemsmart.entity.Account;
import com.systemsmart.factory.AccountFactory;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountControllerTest {

    private static Account account = AccountFactory.buildAccount("1", "Fee", 39469.00,
            37567.00, 1902.00, "11-NOV-2020");
    private static String SECURITY_USERNAME = "admin";
    private static String SECURITY_PASSWORD = "admin123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/account/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("Post date:" + account);
        ResponseEntity<Account> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, account, Account.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        account = postResponse.getBody();
        System.out.println("Saved data:" + account);
        assertEquals(account.getAccountId(), postResponse.getBody().getAccountId());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + account.getAccountId();
        System.out.println("URL: " + url);
        ResponseEntity<Account> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, Account.class);
        assertEquals(account.getAccountId(), response.getBody().getAccountId());
    }

    @Test
    public void c_update() {
        Account updated = new Account.Builder().copy(account).setCreditAmount(account.getCreditAmount()+950.00).build();
        updated = new Account.Builder().copy(updated).setBalanceAmount(account.getDebitAmount()-account.getCreditAmount()).build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post date: " + updated);
        ResponseEntity<Account> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, updated, Account.class);
        assertEquals(account.getAccountId(), response.getBody().getAccountId());
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
    public void e_delete() {
        String url = baseURL + "delete/" + account.getAccountId();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).delete(url);
    }
}