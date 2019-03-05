package com.example.laowa.newfragmentdemo.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.laowa.newfragmentdemo.R;

import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 *
 * Created by laowa on 2019/01/13.
 */

public class RecyclerView_major_Adapter extends RecyclerView.Adapter<RecyclerView_major_Adapter.ViewHolder> {

    private Context mContext;
    private List<MyFriends_Adapter> mMyFriendList;
    private OnItemClickListener mOnItemClickListener;

    public RecyclerView_major_Adapter(Context mContext, List<MyFriends_Adapter> myFriendList) {
        this.mMyFriendList = myFriendList;
        this.mContext = mContext;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public RecyclerView_major_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_friend_main, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                MyFriends_Adapter myfriend = mMyFriendList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + myfriend.getFriend_name(), Toast.LENGTH_SHORT).show();
//                mOnItemClickListener.onItemClick(holder.itemView, position);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("你确认删除吗？");
                builder.setNegativeButton("取消", null);
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int pos = holder.getLayoutPosition();
                        removeData(pos);
                    }
                }).show();
                return false;
            }
        });
        return holder;
    }



    @Override
    public void onBindViewHolder(RecyclerView_major_Adapter.ViewHolder holder, int position) {
        MyFriends_Adapter friend = mMyFriendList.get(position);
        Glide.with(mContext)
                .load(friend.getFriend_pic())
                .error(R.mipmap.ic_xuanfeng)
                .bitmapTransform(new CropCircleTransformation(mContext))
                .into(holder.friend_image);
        holder.friend_age.setText(friend.getFriend_age()+" ");
        holder.friend_major.setText(friend.getFriend_major());
        holder.friend_name.setText(friend.getFriend_name());
        holder.friend_dream.setText(friend.getFriend_dream());
        holder.friend_work.setText(friend.getFriend_work());
        //点击事件
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext,"奔跑在孤傲的路上",Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mMyFriendList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        ImageView friend_image;
        TextView friend_name;
        TextView friend_age;
        TextView friend_dream;
        TextView friend_work;
        TextView friend_major;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            friend_image = view.findViewById(R.id.image2);
            friend_name = view.findViewById(R.id.friend_name2);
            friend_age = view.findViewById(R.id.friend_age2);
            friend_dream = view.findViewById(R.id.friend_dream2);
            friend_work = view.findViewById(R.id.friend_work2);
            friend_major = view.findViewById(R.id.friend_major2);
        }
    }


    //  用于删除数据
    private void removeData(int position) {
        mMyFriendList.remove(position);
        notifyItemRemoved(position);
    }
}
