package com.example.cakedemo.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cakedemo.R;
import com.example.cakedemo.ui.activity.AppData;

import java.util.ArrayList;
import java.util.HashMap;

public class Fragment2 extends Fragment {                                                           // 2.1.新建一个类继承Fragment

    private AppData app;
    private ArrayList<HashMap<String,Object>> list;
    /***
    * 用于创建fragment页面
    * */
    @Nullable
    @Override
                                                                                                    //2.2. 重写OnCreateView()方法
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                                                                                                    //2.3.让fragment关联相应的布局文件
        app = (AppData) getActivity().getApplication();                                                      //获得全局类
        View view = inflater.from(getActivity()).inflate(R.layout.frag2,container,false  );
        initListView(view);

        return view;                                                                                //2.5返回view可以控制fragment滑动可见的内容
    }

    private void initListView(final View view){
                                                                                                    //1.实现左边列表
                                                                                                        //1.1.添加ListView控件到布局里
                                                                                                        //1.2.在java文件里创建集合放入数据
        String[] name = {"lalisa","jisoo","jienne","rose"};
        ArrayList<HashMap<String,Object>> leftlist = new ArrayList<HashMap<String, Object>>();
        HashMap<String,Object>map;
        for (int i=0;i<name.length;i++){
            map = new HashMap<String, Object>();
            map.put("name",name[i]);
            leftlist.add(map);
        }

                                                                                                        //1.3.设计选项布局 建立item1.xml
                                                                                                        //1.4.设置SimpleAdapter适配器
        SimpleAdapter adapter1 = new SimpleAdapter(getActivity(),leftlist,R.layout.item1,
                new String[]{"name"},new int[]{R.id.textView}){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view= super.getView(position, convertView, parent);
                /*没有选中的颜色*/
                view.setBackgroundColor(Color.rgb(176,234,220));
                if(position==0){
                    /*默认选中的颜色*/
                    view.setBackgroundColor(Color.rgb(240,255,255));
                }
                return view;

            }
        };
                                                                                                        //1.5.在java文件里找到ListView控件
        ListView lvleft = view.findViewById(R.id.listview1);
                                                                                                        //1.6.把适配器放进ListView控件4
        lvleft.setAdapter(adapter1);
                                                                                                    //2.实现右边列表

        int[] image1 = {R.drawable.cake1,R.drawable.cake2,R.drawable.cake3,R.drawable.cake4,R.drawable.cake5,
                R.drawable.cake6,R.drawable.cake7,R.drawable.cake8,R.drawable.cake9,R.drawable.cake10,
                R.drawable.cake11,R.drawable.cake12,R.drawable.cake13,R.drawable.cake14,R.drawable.cake15};
        String[] name1 = {"lisa 蛋糕1","蛋糕2","蛋糕3","蛋糕4","蛋糕5","蛋糕6","蛋糕7","蛋糕8","蛋糕9","蛋糕10","蛋糕11",
                "蛋糕12","蛋糕13","蛋糕14","蛋糕15"};
        String[] price1 = {"100","102","99","103","130","100","102","99","103","130","100","102","99","103","130"};

        int[] image2 = {R.drawable.cake16,R.drawable.cake17,R.drawable.cake18,R.drawable.cake19,R.drawable.cake20,
                R.drawable.cake21,R.drawable.cake22,R.drawable.cake23,R.drawable.cake24,R.drawable.cake25,
                R.drawable.cake26,R.drawable.cake27,R.drawable.cake28,R.drawable.cake29,R.drawable.cake30};
        String[] name2 = {"jisoo 蛋糕1","蛋糕2","蛋糕3","蛋糕4","蛋糕5","蛋糕6","蛋糕7","蛋糕8","蛋糕9","蛋糕10","蛋糕11",
                "蛋糕12","蛋糕13","蛋糕14","蛋糕15"};
        String[] price2 = {"100","102","99","103","130","100","102","99","103","130","100","102","99","103","130"};

        final ArrayList<HashMap<String,Object>> lisalist = getList(image1,name1,price1) ;
        final ArrayList<HashMap<String,Object>> jisoolist = getList(image2,name2,price2) ;
        list = lisalist;
        SimpleAdapter adapter2 = new SimpleAdapter(getActivity(),lisalist,R.layout.item2,
                new String[]{"image","name","price"},new int[]{R.id.image1,R.id.textView2,R.id.textView4}){
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                //点击添加按钮  把蛋糕从2添加到3
                Button bt = view.findViewById(R.id.button5);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        app.list.add(lisalist.get(position));
                        Toast.makeText(getActivity(),"已添加",Toast.LENGTH_SHORT).show();
                    }
                });
                return view;
            }
        };

        final ListView lvright = view.findViewById(R.id.listview2);
        lvright.setAdapter(adapter2);


                                                                                             //3.实现左边列表刷新右边列表
        lvleft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    SimpleAdapter adapter2 = new SimpleAdapter(getActivity(),lisalist,R.layout.item2,
                            new String[]{"image","name","price"},new int[]{R.id.image1,R.id.textView2,R.id.textView4});
                    lvright.setAdapter(adapter2);
                }else if (position==1){
                    SimpleAdapter adapter2 = new SimpleAdapter(getActivity(),jisoolist,R.layout.item2,
                            new String[]{"image","name","price"},new int[]{R.id.image1,R.id.textView2,R.id.textView4});
                    lvright.setAdapter(adapter2);
                }
                int n = parent.getChildCount();
                for(int i=0;i<n;i++){
                   /* 没有选中时的颜色*/
                    parent.getChildAt(i).setBackgroundColor(Color.rgb(176,224,230));
                }
                /*选中后的颜色*/
                view.setBackgroundColor(Color.rgb(230,255,255));
                /*list = */
            }
        });

                                                                                                    //4.点击左边列表选项颜色变化
    }

    /**
     * 用与创建列表数据
     * 封装一下（数据比较多，会比较方便管理）*/
    private ArrayList<HashMap<String,Object>> getList(int[] images,String[] names,String[] prices){
        ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String,Object>mapp;
        for (int i=0;i<names.length;i++) {
            mapp = new HashMap<String, Object>();
            mapp.put("image",images[i]);
            mapp.put("name", names[i]);
            mapp.put("price",prices[i]);
            list.add(mapp);
        }
        return list;
    }

}























