package com.sun.speas.config;

import com.sun.speas.properties.SwaggerProperties;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
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

    private final static String GROUP = "SWAGGER";

    /**
     * bean注入的方式之一@PostConstruct 等同于 @Init
     * 注册swagger到IOC中
     */
    @PostConstruct
    public void registerSwagger() {
        if (!swaggerProperties.isEnable()) {
            return;
        }

        // 获取swagger配置属性，创建到IOC中
        String[] groups = StringUtils.split(swaggerProperties.getGroup(), ",");
        String[] groupNames = StringUtils.split(swaggerProperties.getGroupName(), ",");
        String[] scanPackages = StringUtils.split(swaggerProperties.getScanPackage(), ",");

        if (ArrayUtils.isEmpty(groups)) {
            groups = new String[]{"default"};
        }
        if (ArrayUtils.isEmpty(groupNames)) {
            groupNames = new String[]{"speas"};
        }
        if (ArrayUtils.isEmpty(scanPackages)) {
            scanPackages = new String[]{"com.sun.speas"};
        }

        for (int i = 0; i < groups.length; i++) {
            if (i > groupNames.length - 1) {
                continue;
            }
            if (i > scanPackages.length - 1) {
                continue;
            }
            String group = StringUtils.join(GROUP, "-", groups[i]);
            defaultListableBeanFactory.registerSingleton(group, new Docket(DocumentationType.SWAGGER_2)
                    .groupName(groupNames[i])
                    .apiInfo(apiInfo())
                    .enable(swaggerProperties.isEnable())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage(scanPackages[i]))
                    .paths(PathSelectors.any())
                    .build()
                    .pathMapping("/"));
        }

    }

    /**
     * 从配置文件读取配置
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getApiInfo().getTitle())
                .description(swaggerProperties.getApiInfo().getDescription())
                .version(swaggerProperties.getApiInfo().getVersion())
                .build();
    }
}
