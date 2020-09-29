package com.example.friendbook.exception;

import org.springframework.mail.MailException;

public class SpringFriendbookException extends RuntimeException {
    public SpringFriendbookException(String txt_ex_message, Exception e) {
        super(txt_ex_message, e);
    }

    public SpringFriendbookException(String  txt_ex_message){
        super(txt_ex_message);
    }
}
