package com.lhb.orderservice.service.impl;

import com.lhb.orderservice.domain.ProductOrder;
import com.lhb.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
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
//    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public ProductOrder save(Integer userId, Integer productId) {
        //调用方式一
        Map<String,Object> productMap= restTemplate.getForObject("http://product-service/api/v1/product/findById?id=" + productId, Map.class);

        //调用方式二
//        ServiceInstance instance = loadBalancerClient.choose("product-service");
//        String url=String.format("http://%s:%s/api/v1/product/findById?id="+productId,instance.getHost(),instance.getPort());
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String,Object> productMap= restTemplate.getForObject(url, Map.class);

        System.out.println("productMap-->"+productMap);
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateDate(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradNo(UUID.randomUUID().toString());
        productOrder.setPrice((Double) productMap.get("price"));
        productOrder.setProductName(productMap.get("name").toString());

        return productOrder;
    }
}
