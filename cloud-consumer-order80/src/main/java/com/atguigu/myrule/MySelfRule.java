package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author Allion.li
 * create 2022-01-20
 */

@Configuration
public class MySelfRule {


    @Bean
    public IRule MyRule(){
        return  new RandomRule();
    }
}
