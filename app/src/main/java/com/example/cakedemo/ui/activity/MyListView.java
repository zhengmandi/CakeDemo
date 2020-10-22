package com.example.cakedemo.ui.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class MyListView extends ListView {
	 
	 //��д����
	    public MyListView(Context context) {
	        this(context, null);
	    }
	 
	    public MyListView(Context context, AttributeSet attrs) {
	        this(context, attrs, 0);
	    }
	 
	    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }
	 
	    @Override
	    public boolean onInterceptTouchEvent(MotionEvent ev) {
	        return super.onInterceptTouchEvent(ev);
	    }
	 
	 
	    @Override
	    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,//������������൱�ڳ���4
	                MeasureSpec.AT_MOST);//����ģʽȡ���ֵ
	        super.onMeasure(widthMeasureSpec,heightMeasureSpec);//���²����߶�
	    }
	}
	