package com.qxy.minitiktok.logic.network;

import android.util.Log;

import androidx.annotation.NonNull;

import com.qxy.minitiktok.TikTokApplication;
import com.qxy.minitiktok.util.LogUtil;
import com.qxy.minitiktok.util.StringUtil;
import com.qxy.minitiktok.util.ToastUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @Classname TikTokNetwork
 * @Description: 该类封装所有需要用到的网络请求
 * @Created by 康斯坦丁
 * @Date 2022/8/19 16:58
 */
public class TikTokNetwork {

    private TikTokNetwork(){}

    private static TikTokNetwork tikTokNetwork;

    private static final String clientKey = "awi8027ob33cpbg7";
    private static final String clientSecret = "654ac0adbeb6adb6d830bc633e7445d0";
    private static final String grantTypeAccess = "authorization_code";
    private static final String grantTypeClient = "client_credential";
    private static final String grantTypeRefresh = "refresh_token";

    private static String clientToken;
    private static String accessToken;
    private static String refreshToken;
    private static String openId;

    private static final TikTokService tikTokService = RetrofitCreator.create(TikTokService.class);

    public static TikTokNetwork getTikTokNetwork(){
        if(tikTokNetwork == null){
            tikTokNetwork = new TikTokNetwork();
        }
        return tikTokNetwork;
    }

    @NonNull
    @Override
    public String toString() {
        String str = "clientToken: " + clientToken +
                "accessToken: " + accessToken +
                "refreshToken: " + refreshToken +
                "openId: " + openId;
        return str;
    }

    //获取视频影视榜单数据
    public Call<ResponseBody> getMovieData(Integer type,Integer version){
        if(version == null){
            if(clientToken == null)
                getClientToken();
            return tikTokService.getMovieData(type,clientToken);
        }else{
            if(clientToken == null)
                getClientToken();
            return tikTokService.getMovieData(type,version,clientToken);
        }
    }
    public Call<ResponseBody> getMovieData(Integer type){
        return getMovieData(type,null);
    }
    //获取视频影视榜单版本
    public Call<ResponseBody> getMovieDataVersion(Integer type,Long count,Long cursor){
        if(cursor == null){
            if(clientToken == null){
                getClientToken();
            }
            return tikTokService.getMovieDataVersion(type,count,clientToken);
        }
        return tikTokService.getMovieDataVersion(type,count,cursor,clientToken);
    }

    public Call<ResponseBody> getMovieDataVersion(Integer type,Long count){
        return getMovieDataVersion(type,count,null);
    }

    //获取用户公开信息
    public Call<ResponseBody> getUserInfo(){
        return tikTokService.getUserInfo(accessToken,accessToken,openId);
    }
    //查看粉丝列表
    public Call<ResponseBody> getFansList(Integer count,Long cursor){
        if (cursor == null)
            return tikTokService.getFansList(openId,count,null,accessToken);
        return tikTokService.getFansList(openId,count,cursor,accessToken);
    }

    public Call<ResponseBody> getFansList(Integer count){
        return getFansList(count,null);
    }
    //获取用户视频列表
    public Call<ResponseBody> getVideoList(Integer count,Long cursor){
        if(cursor == null){
            return tikTokService.getVideoList(openId,count,null,accessToken);
        }
        return tikTokService.getVideoList(openId,count,cursor,accessToken);
    }

    public Call<ResponseBody> getVideoList(Integer count){
        return getVideoList(count,null);
    }
    //查看用户关注列表
    public Call<ResponseBody> getFollowingList(Integer count,Long cursor){
        if(cursor == null){
            return tikTokService.getFollowingList(openId,count,null,accessToken);
        }
        return tikTokService.getFollowingList(openId,count,cursor,accessToken);
    }

    public Call<ResponseBody> getFollowingList(Integer count){
        return getFollowingList(count,null);
    }
    //查询特定id的视频
    public Call<ResponseBody> getVideoData(String id){
        List<String> ids = new ArrayList<>();
        ids.add(id);
        return tikTokService.getVideoData(openId,accessToken,ids);
    }

    //刷新refresh-token
    public void getNewRefreshToken(){
        if(refreshToken != null)
        tikTokService.getNewRefreshToken(clientKey,refreshToken).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    refreshToken = StringUtil.getFieldValueFromJson(response.body().string(),"refresh_token");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    //刷新access-token
    public void refreshAccessToken(){
        if(accessToken != null){
            tikTokService.refreshAccessToken(clientKey,refreshToken,grantTypeRefresh)
                    .enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        accessToken = StringUtil.getFieldValueFromJson(response.body().string(),
                                "access_token");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }
    //获取client-token
    public void getClientToken(){
        tikTokService.getClientToken(clientSecret,clientKey,grantTypeClient)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            clientToken = StringUtil.getFieldValueFromJson(response.body().string(),
                                    "client_token");
                        } catch (IOException e) {
                            LogUtil.d("client_token: IO异常");
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }

    //授权后执行，获取access-token
    public void getAccessToken(String code){
        tikTokService.getAccessToken(clientSecret,code,clientKey,grantTypeAccess).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    LogUtil.d(response.body().string());
                    String s = response.body().string();
                    if(s != null) {
                        accessToken = StringUtil.getFieldValueFromJson(s,
                                "access_token");
                        refreshToken = StringUtil.getFieldValueFromJson(s,
                                "refresh_token");
                        openId = StringUtil.getFieldValueFromJson(s, "open_id");
                    }
                    else{

                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                LogUtil.d("获取token异常");
                t.printStackTrace();
            }
        });
    }
}
