package com.webApp.webApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class HomeController {

    @GetMapping("/home")
    public HttpStatus responseOK (){
        return HttpStatus.OK;
    }

}
