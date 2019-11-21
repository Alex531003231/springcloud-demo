package com.lhb.orderservice.service;

import com.lhb.orderservice.domain.ProductOrder;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/11/20  15:42;
 * @description:
 */
public interface OrderService {

    /**
     * 模拟下单接口
     * @param userId
     * @param productId
     * @return
     */
    ProductOrder save(Integer userId,Integer productId);
}
