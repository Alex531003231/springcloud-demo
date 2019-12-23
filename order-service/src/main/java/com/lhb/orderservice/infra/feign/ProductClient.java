package com.lhb.orderservice.infra.feign;

import com.lhb.orderservice.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/12/2  15:39;
 * @description: 商品服务客户端
 */
@FeignClient(name = "product-service",fallback = ProductClientFallback.class)
public interface ProductClient {

    @GetMapping("/api/v1/product/findById")
    String findById(@RequestParam(value = "id") Integer id);
}
