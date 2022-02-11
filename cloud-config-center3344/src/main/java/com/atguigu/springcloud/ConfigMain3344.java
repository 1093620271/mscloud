package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description
 * @Author Allion.li
 * create 2022-02-11
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3344.class, args);
    }


}