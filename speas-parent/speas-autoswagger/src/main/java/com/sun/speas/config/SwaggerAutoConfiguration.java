package com.sun.speas.config;

import com.sun.speas.properties.SwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import javax.annotation.PostConstruct;

/**
 * swagger自动注解
 *
 * @author sunxiang
 * @date 2020-11-17 19:10
 **/
@EnableSwagger2WebMvc
@EnableConfigurationProperties(SwaggerProperties.class)
@ConditionalOnProperty(prefix = "speas.swagger", name = "enable", havingValue = "true", matchIfMissing = true)
public class SwaggerAutoConfiguration {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Autowired
    private DefaultListableBeanFactory defaultListableBeanFactory;

    /**
     * bean注入的方式之一@PostConstruct 等同于 @Init
     * 注册swagger到IOC中
     */
    @PostConstruct
    public void registerSwagger(){
        if(!swaggerProperties.isEnable()){
            return;
        }

        // 获取swagger配置属性，创建到IOC中
    }
}
