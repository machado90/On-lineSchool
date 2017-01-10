package com.example.android.on_lineschool;

/**
 * Created by a90ma on 1/10/2017.
 */

public class users {
    private String display_name;
    private String profile_pic;
    private String type;

    public users() {
    }

    public users(String profile_pic, String display_name, String type) {
        this.profile_pic = profile_pic;
        this.display_name = display_name;
        this.type = type;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
