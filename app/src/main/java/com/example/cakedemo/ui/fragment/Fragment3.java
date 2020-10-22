package com.example.cakedemo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import com.example.cakedemo.R;
import com.example.cakedemo.ui.activity.AppData;


public class Fragment3 extends Fragment {     // 2.1.新建一个类继承Fragment

    private AppData app;
    public static SimpleAdapter adapter;
    public static TextView counttv;
    private double price;
    /***
    * 用于创建fragment页面
    * */
    @Nullable
    @Override
                                             //2.2. 重写OnCreateView()方法
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        app = (AppData) getActivity().getApplication();                                              //获得全局类
                                             //2.3.让fragment关联相应的布局文件
        View view = inflater.inflate(R.layout.frag3,container,false  );
        counttv = view.findViewById(R.id.countTV);                                                  //获取总价控件
        initVIew(view);
        return view;                        //2.5返回view可以控制fragment滑动可见的内容

    }

    private void initVIew(View view){

        adapter = new SimpleAdapter(getActivity(),app.list,R.layout.item3,
                new String[]{"image","name","price","number"},new int[]{R.id.imageView,R.id.textView9,R.id.textView11,R.id.numtext12}){
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                View view = super.getView(position,convertView,parent);
                                                                                                    //获得数量控件
                final TextView numTv = view.findViewById(R.id.numtext12);
                final TextView pricetv = view.findViewById(R.id.textView11) ;
                                                                                                    //点击加按钮
                Button add_btn = view.findViewById(R.id.add_btn);
                add_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                                                                                                    //获得单价
                        String pricee = pricetv.getText().toString();
                        price = Double.parseDouble(pricee);
                        int n = (int) app.list.get(position).get("number");
                        n++;
                        app.list.get(position).put("number",n);
                        numTv.setText(n+"");
                        app.count +=price;
                        counttv.setText(app.count+"");                                              //更新总价控件数量

                    }
                });



                Button sub_btn = view.findViewById(R.id.sub_btn);
                sub_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String pricee = pricetv.getText().toString();
                        price = Double.parseDouble(pricee);
                        int n = (int) app.list.get(position).get("number");
                        if(n>1){
                            n--;
                            app.list.get(position).put("number",n);
                            numTv.setText(n+"");
                            app.count -=price;
                            counttv.setText(app.count+"");
                        }else if(n==1){
                            app.count -=price;
                            counttv.setText(app.count+"");                                          //更新总价控件数据
                            app.list.remove(position);                                              //移除当前选项
                            notifyDataSetChanged();
                        }
                    }
                });
                return view;
            }
        };
        ListView lv  = view.findViewById(R.id.listview3);
        lv.setAdapter(adapter);
    }
}













