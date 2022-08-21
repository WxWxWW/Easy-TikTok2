package com.qxy.minitiktok;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ActivityCollector
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/21 23:09
 */
public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity : activities){
            if(!(activity.isFinishing())){
                activity.finish();
            }
        }
        activities.clear();
    }
}
