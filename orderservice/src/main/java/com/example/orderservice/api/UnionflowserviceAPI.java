package com.example.orderservice.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 默认轮询
 * @author Don
 * @date 2021/7/19.
 */
@FeignClient(name = "UNIONFLOW-SERVICE")
public interface UnionflowserviceAPI {
    @RequestMapping(value = "/unionflowservice/getFlowNo",method = RequestMethod.GET)
    String getFlowNo();
}
