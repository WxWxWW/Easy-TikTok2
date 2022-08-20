package com.qxy.minitiktok.logic.dao;

/**
 * @Classname Extra
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/18 19:47
 */
public class Extra {
    //子错误码描述
    private String sub_description;
    //标识请求的唯一id
    private String logid;
    //毫秒级时间戳
    private int now;
    //错误码
    private int error_code;
    //错误码描述
    private String description;
    //子错误码
    private int sub_error_code;

    public void setSub_description(String sub_description) {
        this.sub_description = sub_description;
    }

    public String getSub_description() {
        return this.sub_description;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

    public String getLogid() {
        return this.logid;
    }

    public void setNow(int now) {
        this.now = now;
    }

    public int getNow() {
        return this.now;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public int getError_code() {
        return this.error_code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setSub_error_code(int sub_error_code) {
        this.sub_error_code = sub_error_code;
    }

    public int getSub_error_code() {
        return this.sub_error_code;
    }

}
