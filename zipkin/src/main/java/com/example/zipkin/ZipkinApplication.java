package com.example.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

//pom中引入zipkin-server和zipkin-autoconfigure-ui启动即可成为zipkin服务
//但是io.zipkin.java已经弃用，Spring Boot2.0以后，官方不推荐我们自定义Zipkin服务端，而是使用官方提供的jar包
//直接git上下载zipkin并启动
//自己单独节点启动的话，访问路径为http://localhost:boot端口/zipkin/
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }

}
