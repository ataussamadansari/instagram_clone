package com.example.instagramclone.Home;

public class PostModelClass {
    String comment, link, disc, upload_time, userName;
    int pro_img, your_img, post;

    public PostModelClass(int pro_img, String userName, int post, String like, String disc, String comment, int your_img, String upload_time) {
        this.comment = comment;
        this.link = like;
        this.disc = disc;
        this.upload_time = upload_time;
        this.userName = userName;
        this.pro_img = pro_img;
        this.your_img = your_img;
        this.post = post;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public int getPro_img() {
        return pro_img;
    }

    public void setPro_img(int pro_img) {
        this.pro_img = pro_img;
    }

    public int getYour_img() {
        return your_img;
    }

    public void setYour_img(int your_img) {
        this.your_img = your_img;
    }
}
