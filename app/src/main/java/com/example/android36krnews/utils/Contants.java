package com.example.android36krnews.utils;

import com.example.android36krnews.utils.entity.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/14 0014.
 * 系统里的常量配置
 */
public class Contants {

    public static final String URL = "http://36kr.com/columns/starding";
    public static final String EQUITY_URL = "https://z.36kr.com/api/p/crowd-funding?can_exit=&min_investment=&page=1&per_page=20";
    public static final String EQUITY_URL_ITEM = "https://z.36kr.com/project/";
    public static final String EQUITY_TITLE_ALL = "全部";
    public static final String EQUITY_TITLE_CENTRE = "募资中";
    public static final String EQUITY_TITLE_FINISH = "募资完成";
    public static final String EQUITY_TITLE_SUCCEED = "融资成功";













    public static List<Category> getCategory(){
        List<Category> list = new ArrayList<>();
        list.add(new Category("全部","http://www.36kr.com/columns/starding","all"));
        list.add(new Category("早期项目","http://www.36kr.com/columns/starding","starding"));
        list.add(new Category("B轮后","http://www.36kr.com/columns/bplus","bplus"));
        list.add(new Category("大公司","http://www.36kr.com/columns/company","company"));
        list.add(new Category("资本","http://www.36kr.com/columns/deep","deep"));
        list.add(new Category("深度","http://www.36kr.com/columns/deep","deep"));
        list.add(new Category("研究","http://www.36kr.com/columns/research","research"));
        return list;
    }
}
