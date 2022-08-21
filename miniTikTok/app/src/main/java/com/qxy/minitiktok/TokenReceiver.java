package com.qxy.minitiktok;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

/**
 * @Classname TokenReceiver
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/21 22:05
 */
public class TokenReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("重新授权").setMessage("你的授权已过期，请重新登录")
                .setCancelable(true)
                .setPositiveButton("确定",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
    }
}
