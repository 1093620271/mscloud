package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Allion.li
 * create 2022-02-10
 */
@Service
public class PaymentService {

//    @HystrixCommand(defaultFallback = "paymentInfo_fallBack",commandProperties = {
//         @HystrixProperty(name = "",value = "")
//    })
    public String paumentInfo_OK(Integer id){
        return "线程池  " + Thread.currentThread().getName() + " paymentInfo_OK,id: " + id  + "\t";
    }

        @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
                @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paumentInfo_TimeOut(Integer id){
         if(id < 0){
             throw   new RuntimeException("id -----");
         }
         String serialNumer = IdUtil.simpleUUID();
         return "线程池  " + Thread.currentThread().getName() + " serialNumer " + serialNumer + "\t" +"id ："+ id;

//        int number = 5;
//        try {
//            TimeUnit.SECONDS.sleep(number);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return "线程池  " + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id  + "\t" +"耗时（秒）："+number;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数,请稍后再试， id: " + id;
    }

}
