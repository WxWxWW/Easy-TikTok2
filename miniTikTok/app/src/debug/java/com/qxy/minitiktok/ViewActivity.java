package com.qxy.minitiktok;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.qxy.minitiktok.ui.FlexibleLayout;
import com.qxy.minitiktok.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    private View mHeader;
    private RecyclerView mScrollView;
    private FlexibleLayout mFlexibleLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_person);
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
        mFlexibleLayout = (FlexibleLayout) findViewById(R.id.person_info);
        mHeader = findViewById(R.id.image_avatar);
        mScrollView = findViewById(R.id.ll);

    }
}