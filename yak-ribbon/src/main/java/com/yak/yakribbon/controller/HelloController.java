package com.yak.yakribbon.controller;

import com.yak.yakribbon.service.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloServiceImpl helloService;

    @RequestMapping(value = "/ribbon-hello",method = RequestMethod.GET)
    public String ribbonHello(String name){
        return helloService.helloService(name);
    }
}
