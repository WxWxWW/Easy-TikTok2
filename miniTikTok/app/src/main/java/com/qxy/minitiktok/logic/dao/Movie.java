package com.qxy.minitiktok.logic.dao;

import com.google.type.DateTime;

import java.util.List;

/**
 * @Classname Movie
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/20 23:09
 */

public class Movie {
    //影片ID
    private String id;
    //地区
    private List<String> areas;
    //导演
    private List<String> directors;
    //演员
    private List<String> actors;
    //类型标签
    private List<String> tags;
    //讨论热度
    private Long discussion_hot;
    //搜索热度
    private Long search_hot;
    //热度值
    private Long hot;
    //影响热度
    private Long influence_hot;
    //话题热度值
    private Long topic_hot;
    //猫眼id：只有电影榜返回，可能为空
    private String maoyan_id;
    //中文名
    private String name;
    //英文名
    private String name_en;
    //海报
    private String poster;
    //上映时间
    private DateTime release_date;
    //类型：1=电影 2=电视剧 3=综艺
    private int type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getAreas() {
        return areas;
    }

    public void setAreas(List<String> areas) {
        this.areas = areas;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Long getDiscussion_hot() {
        return discussion_hot;
    }

    public void setDiscussion_hot(Long discussion_hot) {
        this.discussion_hot = discussion_hot;
    }

    public Long getSearch_hot() {
        return search_hot;
    }

    public void setSearch_hot(Long search_hot) {
        this.search_hot = search_hot;
    }

    public Long getHot() {
        return hot;
    }

    public void setHot(Long hot) {
        this.hot = hot;
    }

    public Long getInfluence_hot() {
        return influence_hot;
    }

    public void setInfluence_hot(Long influence_hot) {
        this.influence_hot = influence_hot;
    }

    public Long getTopic_hot() {
        return topic_hot;
    }

    public void setTopic_hot(Long topic_hot) {
        this.topic_hot = topic_hot;
    }

    public String getMaoyan_id() {
        return maoyan_id;
    }

    public void setMaoyan_id(String maoyan_id) {
        this.maoyan_id = maoyan_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public DateTime getRelease_date() {
        return release_date;
    }

    public void setRelease_date(DateTime release_date) {
        this.release_date = release_date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
