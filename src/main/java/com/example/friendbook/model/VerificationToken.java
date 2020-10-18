package com.example.friendbook.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.annotation.Generated;
import javax.persistence.*;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long num_id;
    private String txt_token;
    @OneToOne(fetch = LAZY)
    private User user;
    private Instant expiry_date;

    public VerificationToken() {
    }

    public Long getNum_id() {
        return num_id;
    }

    public void setNum_id(Long num_id) {
        this.num_id = num_id;
    }

    public String getTxt_token() {
        return txt_token;
    }

    public void setTxt_token(String txt_token) {
        this.txt_token = txt_token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Instant expiry_date) {
        this.expiry_date = expiry_date;
    }
}
