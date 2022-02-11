package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IPayMentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import javafx.beans.DefaultProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Allion.li
 * create 2022-02-10
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentInfo_fallback_method")
public class HystrixOderController {
    @Autowired
    IPayMentService iPayMentService;


    @GetMapping("/order/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id){
        return  iPayMentService.paymentInfo_OK(id);
    }

    @GetMapping("/order/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id){
       // int a = 10/0;
//        if(id < 0){
////            throw  new RuntimeException("id 不能小于0");
////        }
        return  iPayMentService.paymentInfo_TimeOut(id);
    }

    public String paymentInfo_fallback_method(){
        return  "系统异常，请稍候重试";
    }

}
