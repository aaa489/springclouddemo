package com.example.orderservice.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡策略
 * @author Don
 * @date 2021/7/19.
 */
@Configuration
public class RibbonConfig {

//    @Bean
//    public IRule getRule(){
//        return new RandomRule();
//    }
}
