package com.example.laowa.newfragmentdemo.adapter;

public class MyFriends_msg_Adapter {
    private String friend_name;
    private String friend_talk;
    private String friend_major;
    private String friend_time;
    private String friend_data;
    private String friend_pic;

    public MyFriends_msg_Adapter(String friend_name, String friend_talk, String friend_major, String friend_time, String friend_data, String friend_pic) {
        this.friend_name = friend_name;
        this.friend_talk = friend_talk;
        this.friend_major = friend_major;
        this.friend_time = friend_time;
        this.friend_data = friend_data;
        this.friend_pic = friend_pic;
    }

    public String getFriend_name() {
        return friend_name;
    }

    public void setFriend_name(String friend_name) {
        this.friend_name = friend_name;
    }

    public String getFriend_talk() {
        return friend_talk;
    }

    public void setFriend_talk(String friend_talk) {
        this.friend_talk = friend_talk;
    }

    public String getFriend_major() {
        return friend_major;
    }

    public void setFriend_major(String friend_major) {
        this.friend_major = friend_major;
    }

    public String getFriend_time() {
        return friend_time;
    }

    public void setFriend_time(String friend_time) {
        this.friend_time = friend_time;
    }

    public String getFriend_data() {
        return friend_data;
    }

    public void setFriend_data(String friend_data) {
        this.friend_data = friend_data;
    }

    public String getFriend_pic() {
        return friend_pic;
    }

    public void setFriend_pic(String friend_pic) {
        this.friend_pic = friend_pic;
    }
}
