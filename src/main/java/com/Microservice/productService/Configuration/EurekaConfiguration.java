package com.Microservice.productService.Configuration;

import com.netflix.appinfo.EurekaInstanceConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;

import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EurekaConfiguration {

    @Value("${eureka.instance.instance-id}")
    private String applicationInstaceId;

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public EurekaInstanceConfig eurekaInstanceConfigBean(InetUtils inetUtils){
        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
        config.setHostname("localhost");
        config.setIpAddress("127.0.0.1");
        config.setNonSecurePort(0);
        config.setInstanceId(applicationInstaceId);
        config.setAppname(applicationName);
        config.setVirtualHostName(applicationName);
        //config.is

        return config;
    }
}
