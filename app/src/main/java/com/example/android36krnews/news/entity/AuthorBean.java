package com.example.android36krnews.news.entity;

import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Auther Created by xzl on 2016/6/16 21:14.
 * E-mail zuliang_xie@sina.com
 *
 * 作者实体类
 */
public class AuthorBean {
    private String mName;//作者名字
    private String mAvatar;//作者头像
    private String mHref; //作者主页地址
    private String mBadge;//作者等级（eg:新人作者）
    private String mDesc;//作者个人说明
    private String mArticleTotal;//发表文章的总量
    private String mReadNum;//文章的阅读总量

    public AuthorBean() {
    }

    public AuthorBean(String mName, String mAvatar, String mHref, String mBadge, String mDesc, String mArticleTotal, String mReadNum) {
        super();
        this.mName = mName;
        this.mAvatar = mAvatar;
        this.mHref = mHref;
        this.mBadge = mBadge;
        this.mDesc = mDesc;
        this.mArticleTotal = mArticleTotal;
        this.mReadNum = mReadNum;
    }

    /**
     * 进行抓取作者信息数据
     * @param doc
     * @return
     */
    public static List<AuthorBean> getAutherBeans(Document doc){
        List<AuthorBean> authorBeens = new ArrayList<AuthorBean>();
        return authorBeens;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAvatar() {
        return mAvatar;
    }

    public void setmAvatar(String mAvatar) {
        this.mAvatar = mAvatar;
    }

    public String getmHref() {
        return mHref;
    }

    public void setmHref(String mHref) {
        this.mHref = mHref;
    }

    public String getmBadge() {
        return mBadge;
    }

    public void setmBadge(String mBadge) {
        this.mBadge = mBadge;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public String getmArticleTotal() {
        return mArticleTotal;
    }

    public void setmArticleTotal(String mArticleTotal) {
        this.mArticleTotal = mArticleTotal;
    }

    public String getmReadNum() {
        return mReadNum;
    }

    public void setmReadNum(String mReadNum) {
        this.mReadNum = mReadNum;
    }

    @Override
    public String toString() {
        return "AuthorBean{" +
                "mName='" + mName + '\'' +
                ", mAvatar='" + mAvatar + '\'' +
                ", mHref='" + mHref + '\'' +
                ", mBadge='" + mBadge + '\'' +
                ", mDesc='" + mDesc + '\'' +
                ", mArticleTotal='" + mArticleTotal + '\'' +
                ", mReadNum='" + mReadNum + '\'' +
                '}';
    }
}
