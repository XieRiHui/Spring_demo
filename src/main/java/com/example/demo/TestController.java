package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "sifanglaicai!";
    }

    @GetMapping("/test")
    public List<String> test(){
        return List.of("facai","baofu","zoushangrenshengdianfeng");
    }
}
