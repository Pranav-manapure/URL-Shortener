package com.url.shortener.url.shortener;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContoller {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello we are ready to build the URL - Shortener Project";
    }
}
