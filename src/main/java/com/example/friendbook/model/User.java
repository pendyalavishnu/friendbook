package com.example.friendbook.model;

//import com.sun.javafx.geom.transform.Identity;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public long num_user_id;
    @NotBlank(message = "Username is required")
    private String txt_username;
    @NotBlank(message = "Password is required")
    private String txt_password;
    @Email
    @NotEmpty(message = "Email is required")
    private String txt_email;
    private Instant created;
    private boolean flg_logged_in;
    private int num_max_login_windows;
    private boolean flg_allow_multiple_login;

    public long getNum_user_id() {
        return num_user_id;
    }

    public void setNum_user_id(long num_user_id) {
        this.num_user_id = num_user_id;
    }

    public String getTxt_username() {
        return txt_username;
    }

    public void setTxt_username(String txt_username) {
        this.txt_username = txt_username;
    }

    public String getTxt_password() {
        return txt_password;
    }

    public void setTxt_password(String txt_password) {
        this.txt_password = txt_password;
    }

    public String getTxt_email() {
        return txt_email;
    }

    public void setTxt_email(String txt_email) {
        this.txt_email = txt_email;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public boolean isFlg_logged_in() {
        return flg_logged_in;
    }

    public void setFlg_logged_in(boolean flg_logged_in) {
        this.flg_logged_in = flg_logged_in;
    }

    public int getNum_max_login_windows() {
        return num_max_login_windows;
    }

    public void setNum_max_login_windows(int num_max_login_windows) {
        this.num_max_login_windows = num_max_login_windows;
    }

    public boolean isFlg_allow_multiple_login() {
        return flg_allow_multiple_login;
    }

    public void setFlg_allow_multiple_login(boolean flg_allow_multiple_login) {
        this.flg_allow_multiple_login = flg_allow_multiple_login;
    }
}
