package com.example.laowa.newfragmentdemo.adapter;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.laowa.newfragmentdemo.FragmentMain.MyFragment_friend;
import com.example.laowa.newfragmentdemo.FragmentMain.MyFragment_me;
import com.example.laowa.newfragmentdemo.FragmentMain.MyFragment_msg;
import com.example.laowa.newfragmentdemo.MainActivity;

/**
 *
 * Created by laowa on 2019/01/12.
 * 页面布局管理器
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 3;
    private MyFragment_msg myFragment1 = null;
    private MyFragment_friend myFragmentFriend = null;
    private MyFragment_me myFragment3 = null;
    SharedPreferences preferences;
 //   private MyFragment4 myFragment4 = null;


    public MyFragmentPagerAdapter(FragmentManager fm,SharedPreferences preferences) {
        super(fm);
        this.preferences = preferences;
        myFragment1 = new MyFragment_msg();
        myFragmentFriend = new MyFragment_friend();
        myFragment3 = new MyFragment_me();

   //     myFragment4 = new MyFragment4();
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//         super.destroyItem(container, position, object);       //滑动完毕后销毁前一个页面
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case MainActivity.PAGE_TWO:
                fragment = myFragmentFriend;
                break;
            case MainActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
//            case MainActivity.PAGE_FOUR:
//                fragment = myFragment4;
        }
        return fragment;
    }
}

