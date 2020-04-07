package com.yak.yakfeign.rpc;

import com.yak.yakfeign.HelloClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="yak-cloud-client",fallback = HelloClientHystrix.class)
public interface HelloClient {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();
}
