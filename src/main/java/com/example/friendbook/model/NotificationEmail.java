package com.example.friendbook.model;

public class NotificationEmail {

    private String txt_subject;
    private String txt_recipient;
    private String txt_body;

    public NotificationEmail() {
    }

    public NotificationEmail(String txt_subject, String txt_recipient, String txt_body) {
        this.txt_subject = txt_subject;
        this.txt_recipient = txt_recipient;
        this.txt_body = txt_body;
    }

    public String getTxt_subject() {
        return txt_subject;
    }

    public void setTxt_subject(String txt_subject) {
        this.txt_subject = txt_subject;
    }

    public String getTxt_recipient() {
        return txt_recipient;
    }

    public void setTxt_recipient(String txt_recipient) {
        this.txt_recipient = txt_recipient;
    }

    public String getTxt_body() {
        return txt_body;
    }

    public void setTxt_body(String txt_body) {
        this.txt_body = txt_body;
    }
}
