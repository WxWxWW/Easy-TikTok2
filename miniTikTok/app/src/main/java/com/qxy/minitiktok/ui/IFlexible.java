package com.qxy.minitiktok.ui;

/**
 * @Classname IFlexible
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/21 19:29
 */
public interface IFlexible {
    //是否准备下拉
    boolean isReady();
    //头部是否准备
    boolean isHeaderReady();
    //改变头部
    void changeHeader(int offsetY);
    //重置头部
    void resetHeader();
}
