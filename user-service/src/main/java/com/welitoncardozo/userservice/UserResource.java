package com.welitoncardozo.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserResource {
    @GetMapping("/test")
    public String test() {
        System.out.println("Hello World!");
        return "test";
    }
}
