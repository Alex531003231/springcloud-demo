package com.lhb.orderservice.controller;

import com.lhb.orderservice.domain.ProductOrder;
import com.lhb.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Object save(@RequestParam("user_id")Integer userId,@RequestParam("product_id")Integer porductId){

        ProductOrder order = orderService.save(userId, porductId);
        return order;
    }
}
