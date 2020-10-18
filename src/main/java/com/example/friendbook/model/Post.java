package com.example.friendbook.model;

import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.persistence.*;
import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long num_post_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "num_user_id", referencedColumnName = "num_user_id")
    private User user;
    private Instant created_date;
    private String txt_postname;
    @Nullable
    private String txt_url;
    @Nullable
    @Lob
    private String txt_description;

    public long getNum_post_id() {
        return num_post_id;
    }

    public void setNum_post_id(long num_post_id) {
        this.num_post_id = num_post_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Instant created_date) {
        this.created_date = created_date;
    }

    public String getTxt_postname() {
        return txt_postname;
    }

    public void setTxt_postname(String txt_postname) {
        this.txt_postname = txt_postname;
    }

    @Nullable
    public String getTxt_url() {
        return txt_url;
    }

    public void setTxt_url(@Nullable String txt_url) {
        this.txt_url = txt_url;
    }

    @Nullable
    public String getTxt_description() {
        return txt_description;
    }

    public void setTxt_description(@Nullable String txt_description) {
        this.txt_description = txt_description;
    }
}
