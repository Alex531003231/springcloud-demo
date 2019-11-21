package com.lhb.orderservice.service.impl;

import com.lhb.orderservice.domain.ProductOrder;
import com.lhb.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/11/20  15:54;
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ProductOrder save(Integer userId, Integer productId) {

        Object obj = restTemplate.getForObject("http://product-service/api/v1/product/findById?id=" + productId, Object.class);
        System.out.println("obj-->"+obj);
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateDate(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradNo(UUID.randomUUID().toString());

        return productOrder;
    }
}
