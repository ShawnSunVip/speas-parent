package com.sun.speas.web;

import com.sun.speas.utils.CharacterUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Objects;

/**
 * @author shawn
 * @descript
 * web配置文件
 *  1。路由配置
 *  2。跨域配置
 *  。。。
 *  其他功能可通过重写WebMvcConfigurer实现
 * @create 2020-11-21 5:41 下午
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(WebProperties.class)
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private WebProperties webProperties;

    /**
     * 路由配置
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
        //区分大小写,默认true
        matcher.setCaseSensitive(webProperties.getPath().isCaseSensitive());
        //是否去除前后空格,默认false
        matcher.setTrimTokens(webProperties.getPath().isTrimTokens());
        //分隔符
        matcher.setPathSeparator(CharacterUtils.PATH_SEPARATOR);
        //是否缓存匹配规则,默认null等于true
        matcher.setCachePatterns(webProperties.getPath().isCachePatterns());
        //设置路由匹配规则
        configurer.setPathMatcher(matcher);
        //设置URL末尾是否支持斜杠，默认true
        configurer.setUseTrailingSlashMatch(webProperties.getPath().isUseTrailingSlashMatch());
        //忽略URL前缀的控制器类
        String[] ignoreUrlPrefixController = StringUtils.split(webProperties.getPath().getIgnoreControllerUrlPrefix(), CharacterUtils.COMMA_EN);
        //给所有的接口统一添加前缀
        configurer.addPathPrefix(webProperties.getPath().getPrefix(), c -> {
            if (!ArrayUtils.contains(ignoreUrlPrefixController, c.getName()) && (BooleanUtils.isTrue(webProperties.getPath().isEnableAllPrefix()))) {
                return true;
            } else {
                return false;
            }
        });
    }

    /**
     * 跨域设置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if(BooleanUtils.isFalse(webProperties.getCors().isEnable())){
            return;
        }
        CorsRegistration corsRegistration = registry.addMapping("/**");
        //允许来自所有域名请求
        if (ArrayUtils.isNotEmpty(webProperties.getCors().getAllowedOrigins())) {
            corsRegistration.allowedOrigins(webProperties.getCors().getAllowedOrigins());
        } else {
            corsRegistration.allowedOrigins("*");
        }
        //设置所允许的HTTP请求方法，*号代表允许所有方法
        if (ArrayUtils.isNotEmpty(webProperties.getCors().getAllowedMethods())) {
            corsRegistration.allowedMethods(webProperties.getCors().getAllowedMethods());
        } else {
            corsRegistration.allowedMethods("*");
        }
        //服务器支持的所有头信息字段，多个字段用逗号分隔；默认支持所有，*号代表所有
        if (ArrayUtils.isNotEmpty(webProperties.getCors().getAllowedHeaders())) {
            corsRegistration.allowedHeaders(webProperties.getCors().getAllowedHeaders());
        } else {
            corsRegistration.allowedHeaders("*");
        }
        //浏览器是否应该发送凭据，如是否允许发送Cookie，true为允许
        if (BooleanUtils.isFalse(webProperties.getCors().isAllowCredentials())) {
            corsRegistration.allowCredentials(false);
        } else {
            corsRegistration.allowCredentials(true);
        }
        //设置响应HEAD,默认无任何设置，不可以使用*号
        if (ArrayUtils.isNotEmpty(webProperties.getCors().getExposedHeaders())) {
            corsRegistration.exposedHeaders(webProperties.getCors().getExposedHeaders());
        }
        //设置多长时间内不需要发送预检验请求，可以缓存该结果，默认1800秒
        if (Objects.nonNull(webProperties.getCors().getMaxAge())) {
            corsRegistration.maxAge(webProperties.getCors().getMaxAge());
        }
    }
}
