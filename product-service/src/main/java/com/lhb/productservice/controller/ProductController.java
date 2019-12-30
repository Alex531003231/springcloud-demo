package com.lhb.productservice.controller;

import com.lhb.productservice.domain.Product;
import com.lhb.productservice.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/11/20  14:16;
 * @description: productController
 */
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private ProductService productService;

    @RequestMapping("/findList")
    public List<Product> findList(){
        List<Product> list = productService.productList();
        return list;
    }

    @RequestMapping("/findById")
    public Product findById(Integer id){

//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Product product = productService.findById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product,result);
        result.setName(result.getName()+" ---> data from port:"+port);
        return result;
    }
}
