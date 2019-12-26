package com.lhb.swaggerservice.api.controller;

import com.lhb.swaggerservice.config.SwaggerApiConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/12/26  14:07;
 * @description:
 */
@RestController
@Api(tags = SwaggerApiConfig.HELLO_SWAGGER)
public class HelloController {

    @ApiOperation("hello测试")
    @GetMapping("/hello")
    public String hello() {
        return "Hello,Swagger";
    }

}
