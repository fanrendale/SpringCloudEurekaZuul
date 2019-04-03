package com.xjf.eurekazuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关路由
 * @author Administrator
 */
//启用网关配置
@EnableZuulProxy
@SpringBootApplication
public class SpringcloudEurekaZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaZuulApplication.class, args);
    }

}
