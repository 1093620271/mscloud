package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IPayMentService;
import javafx.beans.DefaultProperty;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Allion.li
 * create 2022-02-10
 */
@Component
public class PayMentFallBackService  implements IPayMentService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "fallback ------ paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "fallback ------ paymentInfo_TimeOut";
    }
}
