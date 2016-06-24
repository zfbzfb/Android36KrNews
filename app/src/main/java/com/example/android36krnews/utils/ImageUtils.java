package com.example.android36krnews.utils;

/**
 * Created by zuliang on 2016/5/20.
 * 图片处理工具类
 */
public class ImageUtils {

    /**
     * 进行图片地址截取，这里是按照！号分隔的
     * @param url
     * @return
     */
    public static String getCutImageURL(String url){
        if (url.contains("!")){
            String []urlString = url.split("!");
            return urlString[0];
        }
        return url;
    }
}
