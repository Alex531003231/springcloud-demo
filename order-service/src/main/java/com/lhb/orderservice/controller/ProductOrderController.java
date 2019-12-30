package com.lhb.orderservice.controller;

import com.lhb.orderservice.domain.ProductOrder;
import com.lhb.orderservice.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/11/20  15:53;
 * @description:
 */
@RestController
@RequestMapping("api/v1/order")
public class ProductOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@RequestParam("user_id") Integer userId, @RequestParam("product_id") Integer productId, HttpServletRequest request) {

        Map<String,Object> data=new HashMap<>();
        data.put("code",0);
        data.put("data",orderService.save(userId,productId));
//        ProductOrder order = orderService.save(userId, productId);
        return data;
    }

    private Object saveOrderFail(Integer userId, Integer porductId, HttpServletRequest request) {
        //监控警报
        String saveOrderKey = "save-order";
        String sendValue = redisTemplate.opsForValue().get(saveOrderKey);
        final String ip = request.getRemoteAddr();

        new Thread(() -> {
            if (StringUtils.isBlank(sendValue)) {
                System.out.println("紧急短信，用户下单失败，请尽快查找原因!!! ip地址是：" + ip);
                //发送http请求，调用短信服务 -TODO
                redisTemplate.opsForValue().set(saveOrderKey, "save-order-fail", 20, TimeUnit.SECONDS);
            } else {
                System.out.println("已经发送过短信，20秒内不再重复发送!");
            }
        }).start();

        Map<String, Object> msg = new HashMap<>();
        msg.put("code", -1);
        msg.put("msg", "抢购人数太多，您被挤出来了,请稍后重试!");
        return msg;
    }


}
