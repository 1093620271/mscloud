package com.atguigu.springcloud.service;


import com.atguigu.springcloud.service.impl.PayMentFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description
 * @Author Allion.li
 * create 2022-02-10
 */
@Service
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = PayMentFallBackService.class)
//@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE")
public interface IPayMentService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable ("id")Integer id);
}
