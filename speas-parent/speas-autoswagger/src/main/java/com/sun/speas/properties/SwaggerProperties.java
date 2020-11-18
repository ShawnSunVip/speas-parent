package com.sun.speas.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * swagger配置类
 * @author sunxiang
 * @date 2020-11-17 19:10
 **/
@ConfigurationProperties(prefix = "spring.speas.swagger")
public class SwaggerProperties {
    /**
     * swagger开关控制,默认关闭
     */
    private boolean enable =false;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
