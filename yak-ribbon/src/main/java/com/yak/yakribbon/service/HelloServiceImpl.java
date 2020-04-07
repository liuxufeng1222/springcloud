package com.yak.yakribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl {
    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService(String name){
        return restTemplate.getForObject("http://yak-cloud-client/hello?name="+name,String.class);
    }

    public String helloError(String name){
        return "hello"+name+"Error!";
    }
}
