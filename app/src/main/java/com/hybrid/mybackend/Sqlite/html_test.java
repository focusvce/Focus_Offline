package com.hybrid.mybackend.Sqlite;

import java.sql.Date;



import java.sql.Date;

/**
 * Created by adarsh on 4/7/16.
 */
public class html_test {
    int sr_key;
    String link;
    String title;
    String description;
    int up_down;
    int comment_count;
    int uid;
    Date dop;

    public int getSr_key() {
        return sr_key;
    }

    public void setSr_key(int sr_key) {
        this.sr_key = sr_key;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUp_down() {
        return up_down;
    }

    public void setUp_down(int up_down) {
        this.up_down = up_down;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getDop() {
        return dop;
    }

    public void setDop(Date dop) {
        this.dop = dop;
    }
}

