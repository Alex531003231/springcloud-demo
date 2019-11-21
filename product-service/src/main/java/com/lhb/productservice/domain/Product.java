package com.lhb.productservice.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/11/20  11:13;
 * @description: 商品实体类
 */
@Component
public class Product implements Serializable {

    /**
     * 商品id
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     *商品价格
     */
    private double price;
    /**
     * 商品库存
     */
    private Integer store;

    public Product() {
    }

    public Product(Integer id, String name, double price, Integer store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.store = store;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }
}
