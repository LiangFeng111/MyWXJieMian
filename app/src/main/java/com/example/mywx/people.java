package com.example.mywx;

import android.widget.ImageView;
import android.widget.TextView;

public class people {
    private String name;
    private int image;
    private String name2;
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName2() {
        return name2;
    }

    public people(String name, int imageid , String name2,String time) {
        this.name = name;
        this.image = imageid;
        this.name2  = name2;
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
