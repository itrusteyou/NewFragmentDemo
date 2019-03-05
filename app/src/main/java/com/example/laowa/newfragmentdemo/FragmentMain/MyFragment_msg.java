package com.example.laowa.newfragmentdemo.FragmentMain;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.laowa.newfragmentdemo.R;
import com.example.laowa.newfragmentdemo.adapter.FragmentAdapter;
import com.example.laowa.newfragmentdemo.adapter.ListFragment_msg;
import com.example.laowa.newfragmentdemo.adapter.ListFragment_request;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by laowa on 2019/01/12.
 * 第一个页面,好友消息和请求页面
 */

public class MyFragment_msg extends Fragment {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    //悬浮按钮
    private FloatingActionButton floatingActionButton;

    public MyFragment_msg() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_msg, container, false);
       // Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mTabLayout = view.findViewById(R.id.tabs);
        //setSupportActionBar(toolbar);
        mViewPager =  view.findViewById(R.id.viewpager);
        floatingActionButton = view.findViewById(R.id.actonbutton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "你点击了所有好友", Toast.LENGTH_LONG).show();
            }
        });
        initViewPager(view);
        return view;
    }

    private void initViewPager(View view) {

        List<String> titles = new ArrayList<>();
        titles.add("消息");
        titles.add("请求");


        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
     //       Log.i(TAG, "消息页面顶部两个fragment=: " + i);
        }
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            if (i == 0) {
                fragments.add(new ListFragment_msg());
            } else {
                fragments.add(new ListFragment_request());
            }
        }
        FragmentAdapter mFragmentAdapteradapter =
                new FragmentAdapter(getFragmentManager(), fragments, titles);
        //给ViewPager设置适配器
        mViewPager.setAdapter(mFragmentAdapteradapter);
        //将TabLayout和ViewPager关联起来。
        mTabLayout.setupWithViewPager(mViewPager);
        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapteradapter);
    }


}
