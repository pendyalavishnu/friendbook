package com.example.friendbook.model;

//import com.sun.javafx.geom.transform.Identity;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class FB_USERS {
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

}
