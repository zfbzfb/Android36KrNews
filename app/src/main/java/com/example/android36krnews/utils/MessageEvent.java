package com.example.android36krnews.utils;

import com.example.android36krnews.utils.entity.Category;

/**
 * Auther Created by xzl on 2016/6/16 17:08.
 * E-mail zuliang_xie@sina.com
 * <p>
 * 事件类
 */
public class MessageEvent {

    private Category category;

    public MessageEvent(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
