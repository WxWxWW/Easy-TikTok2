package com.qxy.minitiktok.douyindemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bytedance.sdk.open.aweme.CommonConstants;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.aweme.share.Share;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.qxy.minitiktok.R;
import com.qxy.minitiktok.base.BaseActivity;
import com.qxy.minitiktok.databinding.ActivityCallbackBinding;
import com.qxy.minitiktok.logic.network.RetrofitCreator;
import com.qxy.minitiktok.logic.network.TikTokNetwork;
import com.qxy.minitiktok.logic.network.TikTokService;
import com.qxy.minitiktok.logic.vm.CallViewModel;

import java.io.IOException;

import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallbackActivity extends BaseActivity<CallViewModel, ActivityCallbackBinding> implements IApiEventHandler {

    DouYinOpenApi douYinOpenApi;
    String code;
    TikTokNetwork tikTokNetwork = TikTokNetwork.getTikTokNetwork();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        douYinOpenApi = DouYinOpenApiFactory.create(this);
        douYinOpenApi.handleIntent(getIntent(), this);
        //公开信息
        binding.btnUserInfo.setOnClickListener((v) -> {
            tikTokNetwork.getUserInfo().enqueue(new Callback<ResponseBody>() {
                @SneakyThrows
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    binding.textSuccessful.setText(response.body().string());
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        });
        //粉丝列表
        binding.btnFansList.setOnClickListener((v) -> {
            tikTokNetwork.getFansList(10).enqueue(new Callback<ResponseBody>() {
                @SneakyThrows
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    binding.textSuccessful.setText(response.body().string());
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        });
        //关注列表
        binding.btnFollowingList.setOnClickListener((v) -> {
            tikTokNetwork.getFollowingList(10).enqueue(new Callback<ResponseBody>() {
                @SneakyThrows
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    binding.textSuccessful.setText(response.body().string());
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        });
        //电影榜单
        binding.btnMovie.setOnClickListener((v) -> {
            tikTokNetwork.getMovieData(1).enqueue(new Callback<ResponseBody>() {
                @SneakyThrows
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    binding.textSuccessful.setText(response.body().string());
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        });
        //电视剧榜单
        binding.btnTvs.setOnClickListener((v) -> {
            tikTokNetwork.getMovieData(2).enqueue(new Callback<ResponseBody>() {
                @SneakyThrows
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    binding.textSuccessful.setText(response.body().string());
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        });
        //综艺榜单
        binding.btnVarieties.setOnClickListener((v) -> {
            tikTokNetwork.getMovieData(3).enqueue(new Callback<ResponseBody>() {
                @SneakyThrows
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    binding.textSuccessful.setText(response.body().string());
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        });
        //榜单信息版本
        binding.btnVersion.setOnClickListener((v) -> {
            tikTokNetwork.getMovieDataVersion(1,10L).enqueue(new Callback<ResponseBody>() {
                @SneakyThrows
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    binding.textSuccessful.setText(response.body().string());
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        });
        //视频列表
        binding.btnVideoList.setOnClickListener((v) -> {
            tikTokNetwork.getVideoList(5).enqueue(new Callback<ResponseBody>() {
                @SneakyThrows
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    binding.textSuccessful.setText(response.body().string());
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        });
        //特定视频id的数据
        binding.btnVideoData.setOnClickListener((v) -> {
            tikTokNetwork.getVideoData("@9VwNjqPAC8YybCSicNo6F8791GbqNf6AMpR4qg6kKFMRbfD060zdRmYqig357zEB9XxH4lNEORl4vRGHW9x/3Q==").enqueue(new Callback<ResponseBody>() {
                @SneakyThrows
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    binding.textSuccessful.setText(response.body().string());
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        });
        binding.btnToken.setOnClickListener((v)-> {
            binding.textSuccess.setText(tikTokNetwork.toString());
        });
    }

    @Override
    protected Integer getLayoutId() {
        return R.layout.activity_callback;
    }

    @Override
    protected Class<CallViewModel> getViewModelClass() {
        return CallViewModel.class;
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp resp) {
        if (resp.getType() == CommonConstants.ModeType.SHARE_CONTENT_TO_TT_RESP) {
            Share.Response response = (Share.Response) resp;
            Toast.makeText(this, " code：" + response.errorCode + " 文案：" + response.errorMsg, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, DemoActivity.class);
            startActivity(intent);
        } else if (resp.getType() == CommonConstants.ModeType.SEND_AUTH_RESPONSE) {
            Authorization.Response response = (Authorization.Response) resp;
            Intent intent = null;
            if (resp.isSuccess()) {
                Log.d("AuthCode", "onResp: " + ((Authorization.Response) resp).authCode);
                Log.d("AuthCode", "onResp: " + response.authCode);
                Log.d("AuthCode", "onResp: " + response.state);
                Toast.makeText(this, "授权成功，获得权限：" + response.grantedPermissions,
                        Toast.LENGTH_LONG).show();
                tikTokNetwork.getAccessToken(response.authCode);
            }else{
                Toast.makeText(this, "授权失败，权限：" + response.grantedPermissions,
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onErrorIntent(Intent intent) {
        Toast.makeText(this, "Intent出错", Toast.LENGTH_LONG).show();
    }
}