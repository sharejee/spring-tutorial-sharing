package com.sharejee.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Create By: Ron Rith
Create Date: 12/6/2017
*/
@RestController
public class HelloController {
    @RequestMapping("/")
    public String index(){
        return "Hello jsp maven";
    }
}
