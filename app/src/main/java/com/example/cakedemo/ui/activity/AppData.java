package com.example.cakedemo.ui.activity;

import android.app.Application;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 全局类，在正个项目中共享数据
 * **/
public class AppData extends Application {
                                                                                 //用于已选蛋糕数据
    public ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String, Object>>();

    @Override
    public void onCreate() {                  //用于初始化数据
        super.onCreate();
    }
}