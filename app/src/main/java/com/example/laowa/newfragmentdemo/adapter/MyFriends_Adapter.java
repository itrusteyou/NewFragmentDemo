package com.example.laowa.newfragmentdemo.adapter;

public class MyFriends_Adapter {
    private String friend_name;
    private String friend_dream;
    private String friend_major;
    private String friend_work;
    private String friend_pic;
    private int friend_age;

    public MyFriends_Adapter(String friend_name, String friend_dream, String friend_major, String friend_work, String friend_pic, int age) {
        this.friend_name = friend_name;
        this.friend_dream = friend_dream;
        this.friend_major = friend_major;
        this.friend_work = friend_work;
        this.friend_pic = friend_pic;
        this.friend_age = age;
    }

    public String getFriend_name() {
        return friend_name;
    }

    public void setFriend_name(String friend_name) {
        this.friend_name = friend_name;
    }

    public String getFriend_dream() {
        return friend_dream;
    }

    public void setFriend_dream(String friend_dream) {
        this.friend_dream = friend_dream;
    }

    public String getFriend_major() {
        return friend_major;
    }

    public void setFriend_major(String friend_major) {
        this.friend_major = friend_major;
    }

    public String getFriend_work() {
        return friend_work;
    }

    public void setFriend_work(String friend_work) {
        this.friend_work = friend_work;
    }

    public String getFriend_pic() {
        return friend_pic;
    }

    public int getFriend_age() {
        return friend_age;
    }

    public void setFriend_age(int friend_age) {
        this.friend_age = friend_age;
    }

    public void setFriend_pic(String friend_pic) {
        this.friend_pic = friend_pic;
    }
}
