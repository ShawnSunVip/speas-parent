package com.sun.speas.web;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shawn
 * @descript
 * web 基础配置
 * @create 2020-11-21 5:42 下午
 */
@ConfigurationProperties(prefix = "speas.webmvc")
public class WebProperties {

    private Path path;
    private CorsRegister cors;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public CorsRegister getCors() {
        return cors;
    }

    public void setCors(CorsRegister cors) {
        this.cors = cors;
    }

    /**
     * 路由属性配置
     */
    public static class Path {
        //是否开启所有接口的前缀
        private boolean enableAllPrefix = false;
        //区分大小写,默认true
        private boolean caseSensitive = true;
        //是否去除前后空格,默认false
        private boolean trimTokens = false;
        //是否缓存匹配规则,默认null等于true
        private boolean cachePatterns = true;
        //设置URL末尾是否支持斜杠，默认true
        private boolean useTrailingSlashMatch = true;
        //URL默认添加前缀
        private String prefix = "api";
        //忽略指定的路由
        private String ignoreControllerUrlPrefix;

        public boolean isEnableAllPrefix() {
            return enableAllPrefix;
        }

        public void setEnableAllPrefix(boolean enableAllPrefix) {
            this.enableAllPrefix = enableAllPrefix;
        }

        public boolean isCaseSensitive() {
            return caseSensitive;
        }

        public void setCaseSensitive(boolean caseSensitive) {
            this.caseSensitive = caseSensitive;
        }

        public boolean isTrimTokens() {
            return trimTokens;
        }

        public void setTrimTokens(boolean trimTokens) {
            this.trimTokens = trimTokens;
        }

        public boolean isCachePatterns() {
            return cachePatterns;
        }

        public void setCachePatterns(boolean cachePatterns) {
            this.cachePatterns = cachePatterns;
        }

        public boolean isUseTrailingSlashMatch() {
            return useTrailingSlashMatch;
        }

        public void setUseTrailingSlashMatch(boolean useTrailingSlashMatch) {
            this.useTrailingSlashMatch = useTrailingSlashMatch;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getIgnoreControllerUrlPrefix() {
            return ignoreControllerUrlPrefix;
        }

        public void setIgnoreControllerUrlPrefix(String ignoreControllerUrlPrefix) {
            this.ignoreControllerUrlPrefix = ignoreControllerUrlPrefix;
        }
    }

    /**
     * 跨域注册配置
     */
    public static class CorsRegister {
        //开启跨域设置，默认false
        private boolean enable = false;
        //设置来源
        private String[] allowedOrigins;
        //允许HTTP请求方法
        private String[] allowedMethods;
        //允许header
        private String[] allowedHeaders;
        //允许cookies 默认true
        private boolean allowCredentials = true;
        //响应Header
        private String[] exposedHeaders;
        //设置多长时间内不需要发送预检验请求
        private long maxAge = 18000L;

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public String[] getAllowedOrigins() {
            return allowedOrigins;
        }

        public void setAllowedOrigins(String[] allowedOrigins) {
            this.allowedOrigins = allowedOrigins;
        }

        public String[] getAllowedMethods() {
            return allowedMethods;
        }

        public void setAllowedMethods(String[] allowedMethods) {
            this.allowedMethods = allowedMethods;
        }

        public String[] getAllowedHeaders() {
            return allowedHeaders;
        }

        public void setAllowedHeaders(String[] allowedHeaders) {
            this.allowedHeaders = allowedHeaders;
        }

        public boolean isAllowCredentials() {
            return allowCredentials;
        }

        public void setAllowCredentials(boolean allowCredentials) {
            this.allowCredentials = allowCredentials;
        }

        public String[] getExposedHeaders() {
            return exposedHeaders;
        }

        public void setExposedHeaders(String[] exposedHeaders) {
            this.exposedHeaders = exposedHeaders;
        }

        public long getMaxAge() {
            return maxAge;
        }

        public void setMaxAge(long maxAge) {
            this.maxAge = maxAge;
        }
    }
}
