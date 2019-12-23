package com.lhb.orderservice.fallback;

import com.lhb.orderservice.infra.feign.ProductClient;
import org.springframework.stereotype.Component;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/12/23  14:35;
 * @description: 商品服务fallback
 */
@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public String findById(Integer id) {
        System.out.println("feign 调用 product-service findById 异常");
        return null;
    }
}
