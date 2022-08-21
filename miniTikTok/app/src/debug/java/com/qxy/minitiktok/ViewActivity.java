package com.qxy.minitiktok;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;

import com.qxy.minitiktok.ui.FlexibleLayout;
import com.qxy.minitiktok.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    private View mHeader;
    private ScrollView mScrollView;
    private FlexibleLayout mFlexibleLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        initView();
        mFlexibleLayout.setHeader(mHeader)
                .setReadyListener(new FlexibleLayout.OnReadyPullListener() {
                    @Override
                    public boolean isReady() {
                        return mScrollView.getScrollY() == 0;
                    }
                });
    }

    private void initView() {
        mFlexibleLayout = (FlexibleLayout) findViewById(R.id.fv);
        mHeader = findViewById(R.id.header);
        mScrollView = findViewById(R.id.sv);
    }
}