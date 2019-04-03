package com.xjf.eurekazuul.config;

import com.xjf.eurekazuul.filter.AuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 应用配置类，初始化Bean和配置信息
 * @author xjf
 * @date 2019/4/3 15:06
 */
@Configuration
public class EurekaZuulConfig {

    @Bean
    public AuthFilter authFilter(){
        return new AuthFilter();
    }
}
