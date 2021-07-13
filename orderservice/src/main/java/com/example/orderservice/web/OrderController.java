package com.example.orderservice.web;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Don
 * @date 2021/7/9.
 */
@RequestMapping("order")
@RestController
public class OrderController {

    private final RestTemplate restTemplate;

    private final DiscoveryClient discoveryClient;

    public OrderController(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/palceOrder")
    public void placeOrder(){
        List<ServiceInstance> instances = discoveryClient.getInstances("unionflowService");

        // 获取第一个服务信息
        ServiceInstance instanceInfo = instances.get(0);
        //获取ip
        String ip = "localhost";//instanceInfo.getHost();
        //获取port
        int port = instanceInfo.getPort();
        String url  ="http://"+ip+":"+port+"/unionflowservice/getFlowNo";
        String ss = restTemplate.getForObject(url, String.class);
        int i = 0;
    }
}
