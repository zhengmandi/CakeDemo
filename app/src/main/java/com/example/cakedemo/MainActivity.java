package com.example.cakedemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.cakedemo.ui.fragment.Fragment1;
import com.example.cakedemo.ui.fragment.Fragment2;
import com.example.cakedemo.ui.fragment.Fragment3;
import com.example.cakedemo.ui.fragment.Fragment4;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {                                               //1.继承AppCompatActivity或者Fragment来实现(fragment)页面的滑动
    private ViewPager vp;
    Button bt1,bt2,bt3,bt4;
    /**
     *用与创建Activity页面的，会自动运行,所以其它页面要想运行，需要再Activity页面调用
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initfragment(); //调用方法
        initClick();
    }

    /***
     * 实现Fragment+ViewPager架构的实现（滑动翻页）
    */

    private void initfragment(){
                                                                                                    //2.创建fragment集合
        final ArrayList<Fragment> list = new ArrayList<Fragment>() ;
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());
        list.add(new Fragment4());
                                                                                                    // 3.找到ViewPager控件(让fragment关联相应的布局文件)
         vp = findViewById(R.id.pager);
                                                                                                    //4.设置Fragment适配器
        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            int n = 0;
            @NonNull
            @Override
            public Fragment getItem(int position) {                                                 //4.1.设置Fragment页面对象
                return list.get(position);                                                          //4.2.通过数组获得对象
            }

            @Override
            public int getCount() {                        //设置Fragment页面的数量
                return list.size() ;
            }

            @Override
            public void finishUpdate(@NonNull ViewGroup container) {                                //4.3.Fragment页面可见是要执行的代码
                super.finishUpdate(container);
                //滑动时改变颜色
                if(vp.getCurrentItem()==0){

                        bt1.setTextColor(Color.rgb(255, 255, 255));
                        bt2.setTextColor(Color.rgb(0, 0, 0));
                        bt3.setTextColor(Color.rgb(0, 0, 0));
                        bt4.setTextColor(Color.rgb(0, 0, 0));

                }
                else if(vp.getCurrentItem()==1){

                        vp.setCurrentItem(1, false);
                        bt2.setTextColor(Color.rgb(255, 255, 255));
                        bt1.setTextColor(Color.rgb(0, 0, 0));
                        bt3.setTextColor(Color.rgb(0, 0, 0));
                        bt4.setTextColor(Color.rgb(0, 0, 0));

                }
                else if(vp.getCurrentItem()==2){

                    bt3.setTextColor(Color.rgb(255,255,255));    //点击底部颜色变化
                    bt2.setTextColor(Color.rgb(0,0,0));          //其他颜色为原来的颜色
                    bt1.setTextColor(Color.rgb(0,0,0));
                    bt4.setTextColor(Color.rgb(0,0,0));

                }
                else if(vp.getCurrentItem()==3){

                        bt4.setTextColor(Color.rgb(255, 255, 255));
                        bt2.setTextColor(Color.rgb(0, 0, 0));
                        bt3.setTextColor(Color.rgb(0, 0, 0));
                        bt1.setTextColor(Color.rgb(0, 0, 0));

                }
            }
        };
                                                                                                    //5.把适配器放进ViewPager控件
        vp.setAdapter(adapter);



    }

    /**
     * 点击选项，选择打开相应的Fragment的页面
     **/

    private void initClick(){
                                                                                                    //点击选项1打开Fragment1页面
          bt1 = findViewById(R.id.button);
        bt1.setTextColor(Color.rgb(255,255,255));   //不点击默认颜色
        bt1.setOnClickListener(new View.OnClickListener() {                                         //Button1的点击事件
            @Override
            public void onClick(View v) {
                vp.setCurrentItem(0,false);
                bt1.setTextColor(Color.rgb(255,255,255));
                bt2.setTextColor(Color.rgb(0,0,0));
                bt3.setTextColor(Color.rgb(0,0,0));
                bt4.setTextColor(Color.rgb(0,0,0));
            }
        });
                                                                                                    //点击选项2打开Fragment2页面
          bt2 = findViewById(R.id.button2);                                                     //获取button控件
        bt2.setOnClickListener(new View.OnClickListener() {                                         //Button1的点击事件
            @Override
            public void onClick(View v) {
                vp.setCurrentItem(1,false);
                bt2.setTextColor(Color.rgb(255,255,255));
                bt1.setTextColor(Color.rgb(0,0,0));
                bt3.setTextColor(Color.rgb(0,0,0));
                bt4.setTextColor(Color.rgb(0,0,0));


            }
        });
                                                                                                    //点击选项3打开Fragment3页面
         bt3 = findViewById(R.id.button3);                                                     //获取button控件
        bt3.setOnClickListener(new View.OnClickListener() {                                         //Button1的点击事件
            @Override
            public void onClick(View v) {
                vp.setCurrentItem(2,false);
                bt3.setTextColor(Color.rgb(255,255,255));    //点击底部颜色变化
                bt2.setTextColor(Color.rgb(0,0,0));          //其他颜色为原来的颜色
                bt1.setTextColor(Color.rgb(0,0,0));
                bt4.setTextColor(Color.rgb(0,0,0));
            }
        });

                                                                                                    //点击选项4打开Fragment4页面
         bt4 = findViewById(R.id.button4);                                                     //获取button控件
        bt4.setOnClickListener(new View.OnClickListener() {                                         //Button1的点击事件
            @Override
            public void onClick(View v) {
                vp.setCurrentItem(3,false);
                bt4.setTextColor(Color.rgb(255,255,255));
                bt2.setTextColor(Color.rgb(0,0,0));
                bt3.setTextColor(Color.rgb(0,0,0));
                bt1.setTextColor(Color.rgb(0,0,0));
            }
        });
    }
}