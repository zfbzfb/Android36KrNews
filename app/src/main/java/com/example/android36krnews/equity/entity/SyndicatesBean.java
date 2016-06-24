package com.example.android36krnews.equity.entity;

import com.example.android36krnews.utils.Contants;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/18.
 */
public class SyndicatesBean {
    private String logo;
    private String title;
    private String brief;
    private String photo;
    private String collar;
    private String collar2;
    private String initiate;
    private String initiate2;
    private String menber;
    private String menber2;
    private String fund;
    private String goal;
    private String type;
    private String href;

    public SyndicatesBean() {
    }

    public SyndicatesBean(String logo, String title, String brief, String photo, String collar, String collar2, String initiate, String initiate2, String menber, String menber2, String fund, String goal, String type, String href) {
        this.logo = logo;
        this.title = title;
        this.brief = brief;
        this.photo = photo;
        this.collar = collar;
        this.collar2 = collar2;
        this.initiate = initiate;
        this.initiate2 = initiate2;
        this.menber = menber;
        this.menber2 = menber2;
        this.fund = fund;
        this.goal = goal;
        this.type = type;
        this.href = href;
    }

    public static List<SyndicatesBean> getSyndicatesBeans(Document document){
        List<SyndicatesBean> list = new ArrayList<>();
        Elements elements = document.select("div.list-container").select("div");

        for(Element ele : elements){
            SyndicatesBean sy = new SyndicatesBean();
            String url = ele.attr("href");
            sy.setHref(Contants.EQUITY_URL+url);

            Element ele1 = ele.select("company-info").first();
//          logo
            sy.setTitle(ele1.select("a").select("strong").first().text());
            sy.setBrief(ele1.select("div.company-desc").text());

            Elements eles2 = ele.select("ul.funding-info").select("li");
            sy.setCollar(eles2.get(0).select("div.info-left").text());
            sy.setCollar2(eles2.get(0).select("div.info-right").select("a").text());
            sy.setInitiate(eles2.get(1).select("div.info-left").text());
            sy.setInitiate2(eles2.get(1).select("div.info-right").text());
            sy.setMenber(eles2.get(2).select("div.info-left").text());
            sy.setMenber2(eles2.get(2).select("div.info-right").text());

            Element ele3 = ele.select("div.funding-progress").select("div.funding-money-info").first();
            sy.setFund(ele3.select("div.info-left").text());
            sy.setGoal(ele3.select("div.info-right").text());

            sy.setType(ele.select("div.funding-status").text());

            list.add(sy);
        }
        return list;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setCollar(String collar) {
        this.collar = collar;
    }

    public void setCollar2(String collar2) {
        this.collar2 = collar2;
    }

    public void setInitiate(String initiate) {
        this.initiate = initiate;
    }

    public void setInitiate2(String initiate2) {
        this.initiate2 = initiate2;
    }

    public void setMenber(String menber) {
        this.menber = menber;
    }

    public void setMenber2(String menber2) {
        this.menber2 = menber2;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getLogo() {
        return logo;
    }

    public String getTitle() {
        return title;
    }

    public String getBrief() {
        return brief;
    }

    public String getPhoto() {
        return photo;
    }

    public String getCollar() {
        return collar;
    }

    public String getCollar2() {
        return collar2;
    }

    public String getInitiate() {
        return initiate;
    }

    public String getInitiate2() {
        return initiate2;
    }

    public String getMenber() {
        return menber;
    }

    public String getMenber2() {
        return menber2;
    }

    public String getFund() {
        return fund;
    }

    public String getGoal() {
        return goal;
    }

    public String getType() {
        return type;
    }

    public String getHref() {
        return href;
    }
}
