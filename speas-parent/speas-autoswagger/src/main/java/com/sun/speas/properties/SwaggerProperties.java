package com.sun.speas.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * swagger配置类
 * @author sunxiang
 * @date 2020-11-17 19:10
 **/
@ConfigurationProperties(prefix = "speas.swagger")
public class SwaggerProperties {
    /**
     * swagger开关控制,默认关闭
     */
    private boolean enable =false;

    /**
     * 分组，用逗号隔开
     */
    private String group;

    /**
     * 组名，用逗号隔开
     */
    private String groupName;

    /**
     * 扫描包，用逗号隔开
     */
    private String scanPackage;

    /**
     * Api信息
     */
    private ApiInfo apiInfo;


    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getScanPackage() {
        return scanPackage;
    }

    public void setScanPackage(String scanPackage) {
        this.scanPackage = scanPackage;
    }

    public ApiInfo getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(ApiInfo apiInfo) {
        this.apiInfo = apiInfo;
    }

    public static class ApiInfo{
        /**
         * 标题
         */
        private String title;
        /**
         * 描述
         */
        private String description;
        /**
         * 版本号
         */
        private String version;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
