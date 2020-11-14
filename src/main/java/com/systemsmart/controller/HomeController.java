package com.systemsmart.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class  HomeController {

//    @RequestMapping({"/", "/index.xys"})
//    String home() {return "Residence Management Application Demo"; }

    @GetMapping("/")
    public String getAuth(Authentication authentication) {
        return authentication.getName();
    }
}
