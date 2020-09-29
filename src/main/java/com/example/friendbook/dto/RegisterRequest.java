package com.example.friendbook.dto;

public class RegisterRequest {

    private String txt_email;
    private String txt_username;
    private String txt_password;

    public RegisterRequest() {
    }

    public RegisterRequest(String txt_email, String txt_username, String txt_password) {
        this.txt_email = txt_email;
        this.txt_username = txt_username;
        this.txt_password = txt_password;
    }

    public String getTxt_email() {
        return txt_email;
    }

    public void setTxt_email(String txt_email) {
        this.txt_email = txt_email;
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
}
