package com.example.android36krnews.utils.entity;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/14 0014.
 */
public class Category implements Serializable{
    private String mTitle;
    private String mHref;
    private String mType;

    public Category(String mTitle, String mHref, String mType) {
        this.mTitle = mTitle;
        this.mHref = mHref;
        this.mType = mType;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmHref() {
        return mHref;
    }

    public String getmType() {
        return mType;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmHref(String mHref) {
        this.mHref = mHref;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public static List<Category> getCategoryData(Document document){
        List<Category> list = new ArrayList<>();
        Elements elements = document.select("div.categories").select("a");
        for (Element element : elements) {
            String title = element.text();
            String type = element.attr("data-type");
            String links = "http://www.36kr.com";
            String href =links + element.attr("href");
            list.add(new Category(title,href,type));
        }
        return list;
    }
}
