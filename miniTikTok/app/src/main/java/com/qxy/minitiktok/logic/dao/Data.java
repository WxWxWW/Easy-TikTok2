package com.qxy.minitiktok.logic.dao;

import java.util.List;

/**
 * @Classname Data
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/18 19:47
 */
public class Data<T extends Object> {
    //粉丝列表
    private List<T> lists;
    //粉丝总数
    private int total;
    //用于下一页请求的cursor
    private int cursor;
    //错误码
    private int error_code;
    //错误码描述
    private String description;
    //是否还有
    private boolean has_more;
    //生成时间
    private String active_time;

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public String getActive_time() {
        return active_time;
    }

    public void setActive_time(String active_time) {
        this.active_time = active_time;
    }
}
