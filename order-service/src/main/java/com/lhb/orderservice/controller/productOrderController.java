package com.lhb.orderservice.controller;

import com.lhb.orderservice.domain.ProductOrder;
import com.lhb.orderservice.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/11/20  15:53;
 * @description:
 */
@RestController
@RequestMapping("api/v1/order")
public class productOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@RequestParam("user_id")Integer userId,@RequestParam("product_id")Integer productId){

        ProductOrder order = orderService.save(userId, productId);
        return order;
    }

    private Object saveOrderFail(Integer userId,Integer porductId){
        Map<String,Object> msg=new HashMap<>();
        msg.put("code",-1);
        msg.put("msg","抢购人数太多，您被挤出来了,请稍后重试!");
        return msg;
    }


}
