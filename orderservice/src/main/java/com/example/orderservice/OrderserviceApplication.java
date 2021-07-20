package com.example.orderservice;

import com.example.orderservice.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

 /**
   * EnableFeignClients来启用fegin，RibbonClient来定义rbbion负载均衡策略
   * @author: Don 
   * @date: 2021/7/19 15:42
   **/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
//@RibbonClient(name = "UNIONFLOW-SERVICE", configuration = RibbonConfig.class)
@EnableHystrix
@EnableHystrixDashboard
public class OrderserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderserviceApplication.class, args);
    }

}
