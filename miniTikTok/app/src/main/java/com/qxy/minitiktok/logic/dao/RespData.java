package com.qxy.minitiktok.logic.dao;

/**
 * @Classname RespData
 * @Description: 网络请求返回的数据格式
 * @Created by 康斯坦丁
 * @Date 2022/8/18 19:18
 */
public class RespData {
    //返回数据体
    private Data data;
    //额外的数据信息
    private Extra extra;
    //Post请求是否成功消息
    private String message;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
