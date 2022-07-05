package com.company.xiaofeifei.java.learning.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Author zouzhiyong
 */
public class GsonUtil {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    /**
     * 将object对象转成json格式字符串
     */
    public static String toJson(Object object) {
        return GSON.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> tClass) {
        return GSON.fromJson(json, tClass);
    }


}
