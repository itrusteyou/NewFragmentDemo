package com.example.laowa.newfragmentdemo.adapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laowa.newfragmentdemo.R;

import java.util.ArrayList;

/**
 *     消息好友列表
 * Created by laowa on 2019/01/13.
 *
 */

public class ListFragment_msg extends Fragment {



    private RecyclerView mRecyclerView;
    private ArrayList<MyFriends_msg_Adapter> myFriendList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRecyclerView =
                (RecyclerView) inflater.inflate(R.layout.list_fragment, container, false);
        initFriend();
        return mRecyclerView;
    }

    private void initFriend() {

        MyFriends_msg_Adapter one = new MyFriends_msg_Adapter("小红",
                "hi",
                "机械工程",
                "18:23",
                "01-13",
                "http://5b0988e595225.cdn.sohucs.com/images/20181219/aec27193b3834a1694f535ba307995ad.jpeg");
        myFriendList.add(one);
        MyFriends_msg_Adapter two = new MyFriends_msg_Adapter("小张",
                "你好",
                "电子工程",
                "19:50",
                "01-13",
                "http://tupian.qqjay.com/u/2017/1221/1_143855_3.jpg");
        myFriendList.add(two);
        MyFriends_msg_Adapter one1 = new MyFriends_msg_Adapter("小王",
                "hi",
                "机械工程",
                "18:23",
                "01-13",
                "http://5b0988e595225.cdn.sohucs.com/images/20181219/aec27193b3834a1694f535ba307995ad.jpeg");
        myFriendList.add(one1);
        MyFriends_msg_Adapter two2 = new MyFriends_msg_Adapter("小周",
                "你好",
                "电子工程",
                "19:50",
                "01-13",
                "http://tupian.qqjay.com/u/2017/1221/1_143855_3.jpg");
        myFriendList.add(two);
        MyFriends_msg_Adapter one2 = new MyFriends_msg_Adapter("小东",
                "hi",
                "机械工程",
                "18:23",
                "01-13",
                "http://5b0988e595225.cdn.sohucs.com/images/20181219/aec27193b3834a1694f535ba307995ad.jpeg");
        myFriendList.add(one);
        MyFriends_msg_Adapter two3 = new MyFriends_msg_Adapter("小李",
                "你好",
                "电子工程",
                "19:50",
                "01-13",
                "http://tupian.qqjay.com/u/2017/1221/1_143855_3.jpg");
        myFriendList.add(two);
        MyFriends_msg_Adapter one3 = new MyFriends_msg_Adapter("小西",
                "hi",
                "机械工程",
                "18:23",
                "01-13",
                "http://5b0988e595225.cdn.sohucs.com/images/20181219/aec27193b3834a1694f535ba307995ad.jpeg");
        myFriendList.add(one);
        MyFriends_msg_Adapter two4 = new MyFriends_msg_Adapter("小娟",
                "你好",
                "电子工程",
                "19:50",
                "01-13",
                "http://tupian.qqjay.com/u/2017/1221/1_143855_3.jpg");
        myFriendList.add(two);
        MyFriends_msg_Adapter one4 = new MyFriends_msg_Adapter("小花",
                "hi",
                "机械工程",
                "18:23",
                "01-13",
                "http://5b0988e595225.cdn.sohucs.com/images/20181219/aec27193b3834a1694f535ba307995ad.jpeg");
        myFriendList.add(one);
        MyFriends_msg_Adapter two5 = new MyFriends_msg_Adapter("小风",
                "你好",
                "电子工程",
                "19:50",
                "01-13",
                "http://tupian.qqjay.com/u/2017/1221/1_143855_3.jpg");
        myFriendList.add(two);
        MyFriends_msg_Adapter one5 = new MyFriends_msg_Adapter("西澳",
                "hi",
                "机械工程",
                "18:23",
                "01-13",
                "http://5b0988e595225.cdn.sohucs.com/images/20181219/aec27193b3834a1694f535ba307995ad.jpeg");
        myFriendList.add(one);
        MyFriends_msg_Adapter two6 = new MyFriends_msg_Adapter("Alice",
                "你好",
                "电子工程",
                "19:50",
                "01-13",
                "http://tupian.qqjay.com/u/2017/1221/1_143855_3.jpg");
        myFriendList.add(two6);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(new RecyclerView_msg_Adapter(getActivity(), myFriendList));
    }



}
