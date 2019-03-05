package com.example.laowa.newfragmentdemo.adapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.example.laowa.newfragmentdemo.Constant;
import com.example.laowa.newfragmentdemo.R;

import java.util.ArrayList;

/**
 *      本专业好友列表
 * Created by laowa on 2019/01/13.
 */

public class ListFragment_my_major extends Fragment {


    RecyclerViewHeader header;
    private RecyclerView mRecyclerView;
    private ArrayList<MyFriends_Adapter> myFriendList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRecyclerView =
                (RecyclerView) inflater.inflate(R.layout.list_fragment, container, false);
        initFriend();
        header = RecyclerViewHeader.fromXml(getContext(), R.layout.activity_friends_roll);

        return mRecyclerView;
    }

    private void initFriend() {

        MyFriends_Adapter one = new MyFriends_Adapter("张玲飞",
                Constant.dream,
                "机械工程",
                "电子设计",
                Constant.url1,
                22);
        myFriendList.add(one);
        MyFriends_Adapter two = new MyFriends_Adapter("张玲飞",
                Constant.dream,
                "机械工程",
                "电子设计",
                Constant.url2,
                22);
        myFriendList.add(two);
        MyFriends_Adapter three = new MyFriends_Adapter("张玲飞",
                Constant.dream,
                "机械工程",
                "电子设计",
                Constant.url3,
                22);
        myFriendList.add(three);
        MyFriends_Adapter four = new MyFriends_Adapter("张玲飞",
                Constant.dream,
                "机械工程",
                "电子设计",
                Constant.url4,
                22);
        myFriendList.add(four);
        MyFriends_Adapter five = new MyFriends_Adapter("张玲飞",
                Constant.dream,
                "机械工程",
                "电子设计",
                Constant.url5,
                22);
        myFriendList.add(five);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
       // header.attachTo(mRecyclerView);
        mRecyclerView.setAdapter(new RecyclerView_major_Adapter(getActivity(), myFriendList));
    }
}
