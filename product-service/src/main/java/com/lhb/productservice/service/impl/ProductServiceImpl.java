package com.lhb.productservice.service.impl;

import com.lhb.productservice.domain.Product;
import com.lhb.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/11/20  11:39;
 * @description: 商品实现类
 */
@Service
public class ProductServiceImpl implements ProductService {

    public static final Map<Integer,Product> daoMap=new HashMap<>();
    static {
        Product p1 = new Product(1,"iphone11",5999,9000);
        Product p2 = new Product(2,"iphone11ProMax",10999,1000);
        Product p3 = new Product(3,"小米电视4",8999,3000);
        Product p4 = new Product(4,"小米MIX3",3999,2000);
        Product p5 = new Product(5,"小米手环4",229,8000);
        Product p6 = new Product(6,"AirPods2",999,1800);
        Product p7 = new Product(7,"联想Y9000X",14999,100);

        daoMap.put(p1.getId(),p1);
        daoMap.put(p2.getId(),p2);
        daoMap.put(p3.getId(),p3);
        daoMap.put(p4.getId(),p4);
        daoMap.put(p5.getId(),p5);
        daoMap.put(p6.getId(),p6);
        daoMap.put(p7.getId(),p7);
    }


    @Override
    public List<Product> productList() {
        Collection<Product> collection=daoMap.values();
        List<Product> list=new ArrayList<>(collection);
        return list;
    }

    @Override
    public Product findById(Integer id) {
        return daoMap.get(id);
    }

}
