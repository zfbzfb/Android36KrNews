package com.example.android36krnews.news.entity;

import com.example.android36krnews.utils.CTextUtils;
import com.example.android36krnews.utils.ImageUtils;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Auther Created by xzl on 2016/6/16 21:14.
 * E-mail zuliang_xie@sina.com
 *
 * 新闻实体类
 */
public class ArticleBean {
    private String mId;//文章ID
    private String mImgUrl;//文章列表缩略图
    private String mMask;//文章类型
    private String mHref;//文章地址
    private AuthorBean mAuthor;//文章作者信息
    private String mTitle;//文章标题
    private String mBrief;//文章简述
    private String mDate;//文章发表时间
    private String mDateText;//文章发表时间时间 已计算

    public ArticleBean(String mId, String mImgUrl, String mMask, String mHref, AuthorBean mAuthor, String mTitle, String mBrief, String mDate, String mDateText) {
        super();
        this.mId = mId;
        this.mImgUrl = mImgUrl;
        this.mMask = mMask;
        this.mHref = mHref;
        this.mAuthor = mAuthor;
        this.mTitle = mTitle;
        this.mBrief = mBrief;
        this.mDate = mDate;
        this.mDateText = mDateText;
    }

    /**
     * 获取新闻数据
     * @param doc
     * @return
     */
    public static List<ArticleBean> getArticleBeans(Document doc){
        List<ArticleBean> articleBeens = new ArrayList<ArticleBean>();
        //进行排除置顶新闻
        int topSize = 0;
        Elements topElements = doc.getElementsByClass("article-Top");
        if(topElements!=null&&topElements.size()>0){
            topSize=topElements.size();
        }
        Elements elements = doc.select("div.articles").first().select("article");
        for (int i = topSize;i<elements.size();i++) {
            //图标以及文章类型
            Element element = elements.get(i);
            Element a_pic_element = element.select("a.pic").first();
            String imgurl = "";
            String mask = "";
            if (a_pic_element != null) {
                imgurl = ImageUtils.getCutImageURL(a_pic_element.attr("data-lazyload"));
                mask = a_pic_element.text();
            }
            //desc信息 连接地址和标题
            Element desc_element = element.select("div.desc").first();
            String href = desc_element.select("a.title").first().attr("href");
            //进行href过滤 因为网站有文章列表无法点击 ，所以这边直接滤过了
            if (href.equals("javascript:void(0)")) {
                continue;
            }
            String tId = CTextUtils.getArticleId(href);
            href = CTextUtils.getArticleHref(href);
            String title = desc_element.select("a.title").first().text();
            //作者信息
            Element author_element = desc_element.select("div.author").first();
            //查找只存在data-lazyload属性的a标签
            Element link = author_element.select("a").first();
            String author_href = CTextUtils.getArticleHref(link.attr("href"));
            String avatar = ImageUtils.getCutImageURL(link.select("span.avatar").first().attr("data-lazyload"));
            String name = link.text();
            //时间
            Element time_element = author_element.select("time.timeago").first();
            String datetime = "";
            String datetext = "";
            if (time_element != null) {
                datetime = author_element.select("time.timeago").first().attr("title");
                datetext = author_element.select("time.timeago").first().text();
            } else {
                datetime = author_element.select("abbr.timeago").first().attr("title");
                datetext = author_element.select("abbr.timeago").first().text();
            }
            //文章简介
            String brief = desc_element.select("div.brief").first().text();
            AuthorBean authorBean = new AuthorBean();
            authorBean.setmName(name);
            authorBean.setmAvatar(avatar);
            authorBean.setmHref(author_href);
            articleBeens.add(new ArticleBean(tId,imgurl,mask,href,authorBean,title,brief,datetime,datetext));

        }
        return articleBeens;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmImgUrl() {
        return mImgUrl;
    }

    public void setmImgUrl(String mImgUrl) {
        this.mImgUrl = mImgUrl;
    }

    public String getmMask() {
        return mMask;
    }

    public void setmMask(String mMask) {
        this.mMask = mMask;
    }

    public String getmHref() {
        return mHref;
    }

    public void setmHref(String mHref) {
        this.mHref = mHref;
    }

    public AuthorBean getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(AuthorBean mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmBrief() {
        return mBrief;
    }

    public void setmBrief(String mBrief) {
        this.mBrief = mBrief;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmDateText() {
        return mDateText;
    }

    public void setmDateText(String mDateText) {
        this.mDateText = mDateText;
    }

    @Override
    public String toString() {
        return "ArticleBean{" +
                "mId='" + mId + '\'' +
                ", mImgUrl='" + mImgUrl + '\'' +
                ", mMask='" + mMask + '\'' +
                ", mHref='" + mHref + '\'' +
                ", mAuthor=" + mAuthor +
                ", mTitle='" + mTitle + '\'' +
                ", mBrief='" + mBrief + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mDateText='" + mDateText + '\'' +
                '}';
    }
}
