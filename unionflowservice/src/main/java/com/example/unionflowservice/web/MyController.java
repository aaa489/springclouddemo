package com.example.unionflowservice.web;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @author Don
 * @date 2021/7/9.
 */
@RequestMapping("unionflowservice")
@RestController
public class MyController {

    @GetMapping("/getFlowNo")
    public String getFlowNo(){
        System.out.println("收到请求");
        return UUID.randomUUID().toString();
    }
}
