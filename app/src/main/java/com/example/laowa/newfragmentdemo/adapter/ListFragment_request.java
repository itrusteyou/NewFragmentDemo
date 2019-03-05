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
 *      请求好友列表
 * Created by laowa on 2019/01/13.
 */

public class ListFragment_request extends Fragment {



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

        MyFriends_msg_Adapter one = new MyFriends_msg_Adapter("张玲飞",
                "hi",
                "机械工程",
                "18:23",
                "01-13",
                "http://5b0988e595225.cdn.sohucs.com/images/20181219/aec27193b3834a1694f535ba307995ad.jpeg");
        myFriendList.add(one);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(new RecyclerView_msg_Adapter(getActivity(), myFriendList));
    }



}
