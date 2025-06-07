package com.authentication.BasicAuthExample;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/admin")
    @PreAuthorize(("hasRole('ADMIN')"))
    public String admin() {
        return "Hello, Admin!";
    }

    @GetMapping("/user")
    public String user() {
        return "Hello, User!";
    }
}
