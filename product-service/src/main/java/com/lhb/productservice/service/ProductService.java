package com.lhb.productservice.service;

import com.lhb.productservice.domain.Product;

import java.util.List;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/11/20  11:16;
 * @description: 商品service
 */
public interface ProductService {

    List<Product> productList();

    Product findById(Integer id);
}
