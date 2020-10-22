package com.example.cakedemo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cakedemo.R;

/**
 * @author 神奇女侠
 * @deprecate 首页界面
 * 1、2.1.新建一个类继承Fragment
 * 2、2.2. 重写OnCreateView()方法
 * 3、2.3.让fragment关联相应的布局文件
 */
public class Fragment1 extends Fragment {     // 2.1.新建一个类继承Fragment

    /***
    * 用于创建fragment页面
    * */
    @Nullable
    @Override
                                             //2.2. 重写OnCreateView()方法
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                                             //2.3.让fragment关联相应的布局文件
        View view = inflater.inflate(R.layout.frag1,container,false  );

        return view;                        //2.5返回view可以控制fragment滑动可见的内容

    }
}
