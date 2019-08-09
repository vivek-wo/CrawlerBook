package com.vivek.wo.crawlerbook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @RequestMapping("/helloword")
    public String helloword() {
        return "Hello Word";
    }
}
