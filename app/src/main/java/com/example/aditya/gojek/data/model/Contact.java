package com.example.aditya.gojek.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aditya on 09-Feb-17.
 */

public class Contact {

    @SerializedName("id") private int id;
    @SerializedName("first_name") private String first_name;
    @SerializedName("last_name") private String last_name;
    @SerializedName("profile_pic") private String profile_pic;
    @SerializedName("url") private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
