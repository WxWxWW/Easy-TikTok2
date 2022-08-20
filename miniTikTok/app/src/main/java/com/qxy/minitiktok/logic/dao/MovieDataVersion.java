package com.qxy.minitiktok.logic.dao;

import com.google.type.DateTime;

/**
 * @Classname MovieDataVersion
 * @Description: 影视榜单数据版本
 * @Created by 康斯坦丁
 * @Date 2022/8/20 23:37
 */
public class MovieDataVersion {
    //榜单生成时间
    private DateTime active_time;
    //榜单结束时间
    private DateTime end_time;
    //榜单结束时间
    private DateTime start_time;
    //类型：1=电影 2=电视剧 3=综艺
    private int type;
    //榜单版本
    private int version;

    public void setActive_time(DateTime active_time) {
        this.active_time = active_time;
    }

    public DateTime getActive_time() {
        return this.active_time;
    }

    public void setEnd_time(DateTime end_time) {
        this.end_time = end_time;
    }

    public DateTime getEnd_time() {
        return this.end_time;
    }

    public void setStart_time(DateTime start_time) {
        this.start_time = start_time;
    }

    public DateTime getStart_time() {
        return this.start_time;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return this.version;
    }


}
