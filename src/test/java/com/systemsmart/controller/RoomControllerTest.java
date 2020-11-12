package com.systemsmart.controller;

import com.systemsmart.entity.Room;
import com.systemsmart.factory.RoomFactory;
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
public class RoomControllerTest {

    private static Room room = RoomFactory.createRoom(10, "Single", 200, true);
    private static String SECURITY_USERNAME = "admin";
    private static String SECURITY_PASSWORD = "admin123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/systemsmart/room/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println(url);
        System.out.println("Post data: "+ room);
        ResponseEntity<Room> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, room, Room.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(HttpStatus.FORBIDDEN, postResponse.getStatusCode());
        room = postResponse.getBody();
        System.out.println("Saved data: " + room);
        assertEquals(room.getRoomNumber(),postResponse.getBody().getRoomNumber());
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
        String url = baseURL + "read/" + room.getRoomNumber();
        System.out.println("URL: " + url);
        ResponseEntity<Room> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Room.class);
       System.out.println(response);
        System.out.println(response.getBody());

    }

    @Test
    public void c_update() {
        Room updated = new Room.Builder().copy(room).setRoomNumber(2000).build();
        String url = baseURL + "update";
        System.out.println("URL: "+ url);
        System.out.println("Post data: "+ updated);
        ResponseEntity<Room> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, updated, Room.class);
        room = response.getBody();
        assertEquals(room.getRoomNumber(),response.getBody().getRoomNumber());
    }

    @Test

    public void e_delete() {
        String url = baseURL + "delete/" + room.getRoomNumber();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }
}