package com.hybrid.mybackend.Sqlite;

public class likes {
    int login_id;
    int post_id;
    int like_or_not;
    int like_status;

    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getLike_or_not() {
        return like_or_not;
    }

    public void setLike_or_not(int like_or_not) {
        this.like_or_not = like_or_not;
    }

    public int getLike_status() {
        return like_status;
    }

    public void setLike_status(int like_status) {
        this.like_status = like_status;
    }
}

