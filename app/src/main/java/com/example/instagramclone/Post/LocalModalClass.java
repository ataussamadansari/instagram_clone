package com.example.instagramclone.Post;


import android.net.Uri;

public class LocalModalClass {
   /* String img;

    public LocalModalClass(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }*/


    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_VIDEO = 1;

    private String path;
    private int type;

    public LocalModalClass(String path, int type) {
        this.path = path;
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public int getType() {
        return type;
    }
}


