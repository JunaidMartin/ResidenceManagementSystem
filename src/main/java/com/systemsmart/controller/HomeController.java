package com.systemsmart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  HomeController {

    @RequestMapping({"/", "/index.xys"})
    String home() {return "Residence Management Application Demo"; }

}
