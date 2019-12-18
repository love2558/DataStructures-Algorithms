package com.web.java;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * jackson帮助<br>
 * 版权：Copyright (c) 2011-2020<br>
 * 公司：北京活力天汇<br>
 * 作者：罗良杰<br>
 * 版本：1.0<br>
 * 创建日期：18/1/10<br>
 */
public class JacksonUtil {


    private JacksonUtil() {
    }

    /** */
    private static ObjectMapper objectMapper = newInstance();

    public static ObjectMapper newInstance() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 解析器支持解析单引号
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 解析器支持解析结束符
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        return objectMapper;
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            String content = objectMapper.writeValueAsString(obj);
            return content;
        } catch (JsonProcessingException e) {
        }
        return null;
    }

    /**
     * json字符串转map
     * @param content
     * @return
     */
    public static Map<String, Object> toMap(String content) {
        if (content == null || "".equals(content)) {
            return null;
        }
        try {
            Map<String, Object> map = objectMapper.readValue(content, Map.class);
            return map;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
