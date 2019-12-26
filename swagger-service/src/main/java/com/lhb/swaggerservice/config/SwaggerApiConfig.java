package com.lhb.swaggerservice.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/12/26  14:32;
 * @description:
 */
@Configuration
public class SwaggerApiConfig {
    public static final String HELLO_SWAGGER="hello-swagger";

    @Autowired
    public SwaggerApiConfig(Docket docket){
        docket.tags(new Tag(HELLO_SWAGGER,"你好,Swagger"));
    }
}
