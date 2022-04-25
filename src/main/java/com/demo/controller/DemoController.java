package com.demo.controller;

import com.demo.config.OrderProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/get")
    public String test(){
        OrderProperties orderProperties = new OrderProperties();
        return orderProperties.getDesc();
    }
}
