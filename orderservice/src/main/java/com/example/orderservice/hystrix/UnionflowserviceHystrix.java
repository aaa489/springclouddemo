package com.example.orderservice.hystrix;

import com.example.orderservice.api.UnionflowserviceAPI;
import org.springframework.stereotype.Component;

/**
 * @author Don
 * @date 2021/7/23.
 */
@Component
public class UnionflowserviceHystrix implements UnionflowserviceAPI {
    @Override
    public String getFlowNo() {
        return "localFlowNo";
    }
}
