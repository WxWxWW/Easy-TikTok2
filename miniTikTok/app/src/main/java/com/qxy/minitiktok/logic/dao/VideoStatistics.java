package com.qxy.minitiktok.logic.dao;

/**
 * @Classname VideoStatistics
 * @Description: 视频数据信息
 * @Created by 康斯坦丁
 * @Date 2022/8/20 22:55
 */
public class VideoStatistics {
    //转发数
    private int forward_count;
    //评论数
    private int comment_count;
    //点赞数
    private int digg_count;
    //下载数
    private int download_count;
    //播放数，只有作者本人可见。公开视频设为私密后，播放数也会返回0。
    private int play_count;
    //分享数
    private int share_count;

    public void setForward_count(int forward_count){
        this.forward_count = forward_count;
    }
    public int getForward_count(){
        return this.forward_count;
    }
    public void setComment_count(int comment_count){
        this.comment_count = comment_count;
    }
    public int getComment_count(){
        return this.comment_count;
    }
    public void setDigg_count(int digg_count){
        this.digg_count = digg_count;
    }
    public int getDigg_count(){
        return this.digg_count;
    }
    public void setDownload_count(int download_count){
        this.download_count = download_count;
    }
    public int getDownload_count(){
        return this.download_count;
    }
    public void setPlay_count(int play_count){
        this.play_count = play_count;
    }
    public int getPlay_count(){
        return this.play_count;
    }
    public void setShare_count(int share_count){
        this.share_count = share_count;
    }
    public int getShare_count(){
        return this.share_count;
    }
}
