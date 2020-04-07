package com.yak.yakfeign.controller;

import com.yak.yakfeign.rpc.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private HelloClient helloClient;

    @RequestMapping(value = "/yak-feign-hello",method = RequestMethod.GET)
    public String hello(){
        return helloClient.hello();
    }
}
