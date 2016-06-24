package com.example.android36krnews.utils;

/**
 * Created by zuliang on 2016/5/20.
 * 文本字符串相关处理工具类
 */
public class CTextUtils {

    /**
     * /p/5047203.html---->5047203
     * @param href
     * @return
     */
    public static String getArticleId(String href){
        String temp = href.substring(href.lastIndexOf("/")+1);
        if (temp.contains(".")){
            String []Id = temp.split("\\.");
            return Id[0];
        }
        return href;
    }

    /**
     * /p/5047203.html------>http://www.36kr.com/p/5047203.html
     * @param href
     * @return
     */
    public static String getArticleHref(String href){
        String links = "http://www.36kr.com";
        if (href != null&& !href.contains("http://www.36kr.com")){
            return links + href;
        }
        return href;
    }
}
