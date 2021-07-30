package com.example.orderservice.web;

import com.example.orderservice.api.UnionflowserviceAPI;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
public class OrderController {

    @Value("${word}")
    private String word;

    //使用fegin
    private UnionflowserviceAPI unionflowserviceAPI;

    //不使用fegin
    private final RestTemplate restTemplate;

    private final DiscoveryClient discoveryClient;

    public OrderController(RestTemplate restTemplate, DiscoveryClient discoveryClient, UnionflowserviceAPI unionflowserviceAPI) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
        this.unionflowserviceAPI = unionflowserviceAPI;
    }

    @GetMapping("/palceOrder")
    public void placeOrder(){
//        //使用DiscoveryClient取得服务实例并调用，可以自己定义负载均衡策略
//        List<ServiceInstance> instances = discoveryClient.getInstances("unionflowService");
//
//        // 获取第一个服务信息
//        ServiceInstance instanceInfo = instances.get(0);
//        //获取ip
//        String ip = "localhost";//instanceInfo.getHost();
//        //获取port
//        int port = instanceInfo.getPort();
//        String url  ="http://"+ip+":"+port+"/unionflowservice/getFlowNo";

//        //使用openfegin做本地化调用
//        String flowNo = unionflowserviceAPI.getFlowNo();

        //使用ribbon做负载均衡调用，RestTemplate定义上需加LoadBalanced注解，host才能填服务名
        String url  ="http://UNIONFLOW-SERVICE/unionflowservice/getFlowNo";
        String ss = restTemplate.getForObject(url, String.class);
        System.out.println(ss);
    }

    @GetMapping("/removeOrder")
    @HystrixCommand(fallbackMethod = "error")
    public void removeOrder(String id){
        //throw new RuntimeException("手动抛出异常");
        String url  ="http://UNIONFLOW-SERVICE-1/unionflowservice/getFlowNo";
        String ss = restTemplate.getForObject(url, String.class);
        System.out.println(ss);
    }

    public void error(String id) {
        String msg = "hi,"+id+",sorry,error!";
    }
}
