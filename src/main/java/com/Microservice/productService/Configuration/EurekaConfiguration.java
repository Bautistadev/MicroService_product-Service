package com.Microservice.productService.Configuration;

import com.netflix.appinfo.EurekaInstanceConfig;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;

import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class EurekaConfiguration {

    @Value("${instance-id}")
    private String applicationInstaceId;

    @Value("${application.name}")
    private String applicationName;



    @Bean
    public EurekaInstanceConfig eurekaInstanceConfigBean(InetUtils inetUtils) throws IOException {
        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
        config.setHostname("localhost");
        config.setIpAddress("127.0.0.1");
        config.setInstanceId(applicationInstaceId);
        config.setAppname(applicationName);
        config.setVirtualHostName(applicationName);
        config.setStatusPageUrl("http://localhost:"+config.getNonSecurePort()+"/swagger-ui/index.html#/");

        return config;
    }


    @Bean
    public EurekaClientConfigBean eurekaClientConfigBean(){
        EurekaClientConfigBean configBean = new EurekaClientConfigBean();
        return configBean;
    }



}
