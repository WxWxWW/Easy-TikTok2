package com.qxy.minitiktok.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.qxy.minitiktok.util.LogUtil;

import retrofit2.http.Header;

/**
 * @Classname FlexibieLayout
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/21 18:32
 */
public class FlexibleLayout extends FrameLayout implements IFlexible{

    private boolean isEnable = true;

    private float initialY,initialX;

    private int headerHeight = 0;

    private int headerWidth = 0;

    private View headerView;

    private boolean isBeginDragged;

    private boolean headerSizeReady;

    public interface OnPullListener {

        /**
         * 下拉
         * @param offset
         */
        void onPull(int offset);

        /**
         * 松开
         */
        void onRelease();
    }

    public interface OnReadyPullListener{
        boolean isReady();
    }

    private OnReadyPullListener mListener;

    private OnPullListener mOnPullListener;

    private int maxPullHeight = getScreenWidth() / 3;


    public FlexibleLayout(@NonNull Context context) {
        this(context, null);
    }

    public FlexibleLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlexibleLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        headerSizeReady = false;
    }


    //判断是否为下拉动作
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        LogUtil.i("onInterceptTouchEvent");
        if(isEnable && isReady() && isHeaderReady()) {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    LogUtil.i("onInterceptTouchEvent down");
                    initialX = ev.getX();
                    initialY = ev.getY();
                    isBeginDragged = false;
                    break;
                case MotionEvent.ACTION_MOVE:
                    LogUtil.i("onInterceptTouchEvent move");
                    float diffY = ev.getY() - initialY;
                    float diffX = ev.getX() - initialX;
                    if (diffY > 0 && diffY / Math.abs(diffX) > 2) {
                        isBeginDragged = true;
                        LogUtil.i("onInterceptTouchEvent return ture");
                        return true;
                    }
                    break;
                default:
                    break;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.i("onTouchEvent");
        if(isEnable && isReady() && isHeaderReady()) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_MOVE:
                    if (isBeginDragged) {
                        float diffY = event.getY() - initialY;
                        changeHeader((int) diffY);
                        if(mOnPullListener != null)
                            mOnPullListener.onPull((int) diffY);
                        LogUtil.i("onTouchEvent return true");
                        return true;
                    }
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    if (isBeginDragged) {
                        resetHeader();
                        if(mOnPullListener != null)
                            mOnPullListener.onRelease();
                        return true;
                    }
                    break;
                default:
                    break;
            }
        }
        return super.onTouchEvent(event);
    }


    @Override
    public boolean isReady() {
        return mListener != null && mListener.isReady();
    }

    @Override
    public boolean isHeaderReady() {
        return headerView != null && headerSizeReady;
    }

    @Override
    public void changeHeader(int offsetY) {
        PullAnimatorUtil.pullAnimator(headerView, headerHeight, headerWidth, offsetY, maxPullHeight);
    }

    @Override
    public void resetHeader() {
        PullAnimatorUtil.resetAnimator(headerView, headerHeight, headerWidth);
    }

    public FlexibleLayout setEnable(boolean isEnable) {
        this.isEnable = isEnable;
        return this;
    }

    public FlexibleLayout setHeader(View header) {
        headerView = header;
        headerView.post(new Runnable() {
            @Override
            public void run() {
                headerHeight = headerView.getHeight();
                headerWidth = headerView.getWidth();
                headerSizeReady = true;
            }
        });
        return this;
    }

    public FlexibleLayout setMaxPullHeight(int height) {
        maxPullHeight = height;
        return this;
    }

    public FlexibleLayout setReadyListener(OnReadyPullListener listener) {
        mListener = listener;
        return this;
    }

    public FlexibleLayout setOnPullListener(OnPullListener onPullListener) {
        mOnPullListener = onPullListener;
        return this;
    }

    private int getScreenWidth() {
        WindowManager mWindowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        if (mWindowManager != null) {
            mWindowManager.getDefaultDisplay().getMetrics(metrics);
            return metrics.widthPixels;
        } else {
            return 300;
        }
    }
}
