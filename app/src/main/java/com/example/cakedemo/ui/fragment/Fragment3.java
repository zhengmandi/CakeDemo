package com.example.cakedemo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cakedemo.R;
import com.example.cakedemo.ui.activity.AppData;


public class Fragment3 extends Fragment {     // 2.1.新建一个类继承Fragment

    private AppData app;
    public static SimpleAdapter adapter;
    /***
    * 用于创建fragment页面
    * */
    @Nullable
    @Override
                                             //2.2. 重写OnCreateView()方法
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

                                             //2.3.让fragment关联相应的布局文件
        View view = inflater.from(getActivity()).inflate(R.layout.frag3,container,false  );
        app = (AppData) getActivity().getApplication();
        initVIew(view);

        return view;                        //2.5返回view可以控制fragment滑动可见的内容

    }

    private void initVIew(View view){

        adapter = new SimpleAdapter(getActivity(),app.list,R.layout.item3,
                new String[]{"image","name","price"},new int[]{R.id.imageView,R.id.textView9,R.id.textView11});
        ListView lv  = view.findViewById(R.id.listview3);
        lv.setAdapter(adapter);
    }
}













