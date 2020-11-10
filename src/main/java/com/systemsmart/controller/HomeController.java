package com.systemsmart.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:6677", allowCredentials = "true" )
public class  HomeController {

    @RequestMapping({"/", "/index.xys"})
    String home() {return "Residence Management Application Demo"; }

}
