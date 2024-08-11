package com.example.instagramclone.Reel;

public class ReelModelClass {
    String videoUrl,user_name, like, comment, share, disc, sound_text;
    int user_profile, sound_profile;

    public ReelModelClass(String videoUrl, String user_name, String like, String comment, String share, String disc, String sound_text, int user_profile, int sound_profile) {
        this.videoUrl = videoUrl;
        this.user_name = user_name;
        this.like = like;
        this.comment = comment;
        this.share = share;
        this.disc = disc;
        this.sound_text = sound_text;
        this.user_profile = user_profile;
        this.sound_profile = sound_profile;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getSound_text() {
        return sound_text;
    }

    public void setSound_text(String sound_text) {
        this.sound_text = sound_text;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public int getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(int user_profile) {
        this.user_profile = user_profile;
    }

    public int getSound_profile() {
        return sound_profile;
    }

    public void setSound_profile(int sound_profile) {
        this.sound_profile = sound_profile;
    }
}
