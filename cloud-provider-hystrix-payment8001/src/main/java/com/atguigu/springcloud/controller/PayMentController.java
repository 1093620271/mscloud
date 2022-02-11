package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Allion.li
 * create 2022-02-10
 */
@RestController
@Slf4j
public class PayMentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable ("id")Integer id){
        String result = paymentService.paumentInfo_OK(id);
        log.info("*****Result:" + result);
        return  result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable ("id")Integer id){
        String result = paymentService.paumentInfo_TimeOut(id);
        log.info("*****Result:" + result);
        return  result;
    }
}
