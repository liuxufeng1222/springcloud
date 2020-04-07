package com.yak.yakfeign;

import com.yak.yakfeign.rpc.HelloClient;
import org.springframework.stereotype.Component;

@Component
public class HelloClientHystrix implements HelloClient {
    @Override
    public String hello() {
        return "sorry lala!";
    }
}
