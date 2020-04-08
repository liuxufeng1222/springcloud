package com.yak.yakconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class YakConfigClientApplication {

    @Value("${order.name}")
    String orderName;

    @RequestMapping("/test")
    public String test() {
        return "client ====>>> " + orderName;
    }

    public static void main(String[] args) {
        SpringApplication.run(YakConfigClientApplication.class, args);
    }

}
