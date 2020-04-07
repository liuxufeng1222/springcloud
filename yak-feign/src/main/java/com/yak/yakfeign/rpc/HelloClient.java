package com.yak.yakfeign.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="yak-cloud-client")
public interface HelloClient {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();
}
