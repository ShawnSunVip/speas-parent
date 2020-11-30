package com.sun.speas.utils;

import com.sun.speas.common.CharacterUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @author shawn
 * @descript UUID生成工具
 * @create 2020-11-29 7:15 下午
 */
public class UUIDUtils {

    /**
     * 自动生成用户令牌
     */
    public static String generation() {
        return StringUtils.replace(randomUUID(), CharacterUtils.LINE_THROUGH_CENTER, "");
    }

    /**
     * 生成唯一标识
     *
     * @return
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }
}
