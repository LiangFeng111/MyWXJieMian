package com.example.mywx;

public class TonXunLu {
    private String name;
    private String firstLetter;
    private int img;

    public TonXunLu(String name, int img,String firstLetter) {
        this.name = name;
        this.img = img;
        this.firstLetter = firstLetter;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
