package com.qxy.minitiktok.logic.network;

import java.net.URL;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @Classname DataApI
 * @Description: 目前在调试数据接口
 * @Created by 康斯坦丁
 * @Date 2022/8/17 23:56
 * refresh_token:rft.4bc12e936c008f197262c18878e9ab9er6sJSMwOZngkXwBsmYuDQojGSoMp
 * access_token:act.d70d602ce6c32887abe891a29d16aa0f6P2vQiliJjFvtfVFNMknTfbuMx8R
 * access_token:act.d70d602ce6c32887abe891a29d16aa0f6P2vQiliJjFvtfVFNMknTfbuMx8R
 * open_id:
 * client_key:awi8027ob33cpbg7
 * client_secret:654ac0adbeb6adb6d830bc633e7445d0
 */
public interface TikTokService {
    //抖音数据URL
    static final String URL = "https://open.douyin.com";
    //静默授权
    static final String URL_SILENT = "https://aweme.snssdk.com/";

    //获取access_token和refresh_token
    //access_token 15天有效期 refresh_token 30天有效期
    //grantType = "authorization_code"
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/oauth/access_token/")
    Call<ResponseBody> getAccessToken(@Field("client_secret") String clientSecret,@Field("code") String authCode
    ,@Field("client_key") String clientKey,@Field("grant_type") String grantType);

    //刷新refresh_token
    //限制刷新次数 5次后需要重新授权
    @FormUrlEncoded
    @Headers("Content-Type: multipart/form-data")
    @POST("/oauth/renew_refresh_token/")
    Call<ResponseBody> getNewRefreshToken(@Field("client_key") String clientKey,
                                       @Field("refresh_token") String refreshToken);

    //获取client_token
    //有效时间为2小时
    //grantType = "client_credential"
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/oauth/client_token/")
    Call<ResponseBody> getClientToken(@Field("client_secret") String clientSecret
            ,@Field("client_key") String clientKey,@Field("grant_type") String grantType);

    //刷新access_token
    //grantType = "refresh_token"
    @FormUrlEncoded
    @Headers("Content-Type: multipart/form-data")
    @POST("/oauth/refresh_token/")
    Call<ResponseBody> refreshAccessToken(@Field("client_key") String clientKey,
                                       @Field("refresh_token") String refreshToken,
                                       @Field("grant_type") String grantType);

    //获取用户公开信息,需要授权
    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("/oauth/userinfo/")
    Call<ResponseBody> getUserInfo(@Header("access-token") String accessToken,
                                   @Field("access-token") String access_Token,
                                   @Field("open_id") String openId);

    //获取粉丝列表
    //目前无效
    @Headers("Content-Type: application/json")
    @GET("/fans/list/")
    Call<ResponseBody> getFansList(@Query("open_id") String openId,
                                   @Query("count") Integer count,
                                   @Query("cursor") Long cursor,
                                    @Header("access-token") String accessToken);

    @Headers("Content-Type: application/json")
    @GET("/fans/list/")
    Call<ResponseBody> getFansList(@Query("open_id") String openId,
                                   @Query("count") Integer count,
                                   @Header("access-token") String accessToken);

    //获取关注列表
    //目前无效
    @Headers("Content-Type: application/json")
    @GET("/following/list/")
    Call<ResponseBody> getFollowingList(@Query("open_id") String openId,
                                   @Query("count") Integer count,
                                   @Query("cursor") Long cursor,
                                   @Header("access-token") String accessToken);
    @Headers("Content-Type: application/json")
    @GET("/following/list/")
    Call<ResponseBody> getFollowingList(@Query("open_id") String openId,
                                        @Query("count") Integer count,
                                        @Header("access-token") String accessToken);

    //查询授权账号视频列表
    //目前无效
    @Headers("Content-Type: application/json")
    @GET("/video/list/")
    Call<ResponseBody> getVideoList(@Query("open_id") String openId,
                                    @Query("count") Integer count,
                                    @Query("cursor") Long cursor,
                                    @Header("access-token") String accessToken);
    @Headers("Content-Type: application/json")
    @GET("/video/list/")
    Call<ResponseBody> getVideoList(@Query("open_id") String openId,
                                    @Query("count") Integer count,
                                    @Header("access-token") String accessToken);

    //查询特定视频的视频数据
    //目前无效
    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("/video/data/")
    Call<ResponseBody> getVideoData(@Field("open_id") String openId,
                                    @Header("access-token") String accessToken,
                                    @Body @Field("item_ids") List<String> itemIds);


    //获取榜单数据
    @Headers("Content-Type: application/json")
    @GET("/discovery/ent/rank/item/")
    Call<ResponseBody> getMovieData(@Query("type") Integer type,
                                    @Query("version") Integer version,
                                    @Header("access-token") String clientToken);

    @Headers("Content-Type: application/json")
    @GET("/discovery/ent/rank/item/")
    Call<ResponseBody> getMovieData(@Query("type") Integer type,
                                    @Header("access-token") String clientToken);

    //获取榜单数据版本
    @Headers("Content-Type: application/json")
    @GET("/discovery/ent/rank/version/")
    Call<ResponseBody> getMovieDataVersion(@Query("type") Integer type,
                                           @Query("count") Long count,
                                           @Query("cursor") Long cursor,
                                           @Header("access-token") String clientToken);
    @Headers("Content-Type: application/json")
    @GET("/discovery/ent/rank/version/")
    Call<ResponseBody> getMovieDataVersion(@Query("type") Integer type,
                                           @Query("count") Long count,
                                           @Header("access-token") String clientToken);
}
