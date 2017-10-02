package com.example.activitytest;

/**
 * Created by Administrator on 2017/8/10.
 */

public class Fruit {
    private String name;
    private int imageId;
    public Fruit(String name,int imageId){
        this.imageId = imageId;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int  getImageId(){
        return imageId;
    }
}
