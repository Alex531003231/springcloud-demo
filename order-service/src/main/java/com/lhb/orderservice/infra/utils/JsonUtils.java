package com.lhb.orderservice.infra.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/12/2  16:13;
 * @description: Json工具类
 */
public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Json转对象的方法
     */
    public static JsonNode str2JsonNode(String str){
        try {
            return objectMapper.readTree(str);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
