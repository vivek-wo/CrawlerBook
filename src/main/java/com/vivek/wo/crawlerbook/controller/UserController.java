package com.vivek.wo.crawlerbook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @RequestMapping("/index")
    public Map<String, String> userLogin() {
        Map<String, String> map = new HashMap();
        map.put("1", "Lissa");
        return map;
    }
}
