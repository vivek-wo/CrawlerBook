package com.vivek.wo.crawlerbook.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getUser() {
        return "Hello User";
    }

    @PostMapping("/login")
    public void userLogin(Authentication authentication) {

    }
}
