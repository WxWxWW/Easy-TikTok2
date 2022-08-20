package com.qxy.minitiktok.logic.dao;

/**
 * @Classname VideoData
 * @Description: 视频信息
 * @Created by 康斯坦丁
 * @Date 2022/8/20 16:19
 */
public class Video {
    //视频标题
    private String title;
    //是否置顶
    private boolean is_top;
    //视频创建时间戳
    private int create_time;
    //表示是否审核结束。审核通过或者失败都会返回true，审核中返回false。
    private boolean is_reviewed;
    //表示视频状态。1:已发布; 2:不适宜公开; 4:审核中
    private int video_status;
    //视频播放页面。视频播放页可能会失效，请在观看视频前调用/video/data/获取最新的播放页
    private String share_url;
    //视频id
    private String item_id;
    //媒体类型。2:图集;4:视频
    private int media_type;
    //视频封面
    private String cover;
    //统计数据
    private VideoStatistics statistics;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setIs_top(boolean is_top) {
        this.is_top = is_top;
    }

    public boolean getIs_top() {
        return this.is_top;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public int getCreate_time() {
        return this.create_time;
    }

    public void setIs_reviewed(boolean is_reviewed) {
        this.is_reviewed = is_reviewed;
    }

    public boolean getIs_reviewed() {
        return this.is_reviewed;
    }

    public void setVideo_status(int video_status) {
        this.video_status = video_status;
    }

    public int getVideo_status() {
        return this.video_status;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getShare_url() {
        return this.share_url;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_id() {
        return this.item_id;
    }

    public void setMedia_type(int media_type) {
        this.media_type = media_type;
    }

    public int getMedia_type() {
        return this.media_type;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCover() {
        return this.cover;
    }

    public void setStatistics(VideoStatistics statistics) {
        this.statistics = statistics;
    }

    public VideoStatistics getStatistics() {
        return this.statistics;
    }
}
