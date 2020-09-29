package com.example.friendbook.service;

import com.example.friendbook.dto.RegisterRequest;
import com.example.friendbook.model.NotificationEmail;
import com.example.friendbook.model.User;
import com.example.friendbook.model.VerificationToken;
import com.example.friendbook.repository.UserRepository;
import com.example.friendbook.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private BCryptPasswordEncoder password_encoder;
    @Autowired
    UserRepository user_repo;
    @Autowired
    VerificationTokenRepository verification_token_repo;
    @Autowired
    MailService mail_service;

    public void signup(RegisterRequest register_request){
        User user = new User();
        user.setTxt_username(register_request.getTxt_username());
        user.setTxt_email(register_request.getTxt_email());
        user.setTxt_password(password_encoder.encode(register_request.getTxt_password()));
        user.setCreated(Instant.now());
        user.setIs_enbled(false);
        user_repo.save(user);

        String txt_token = generateVerificationToken(user);

        mail_service.sendMail(new NotificationEmail("Please activate your account", user.getTxt_email(),
                "http://localhost:8080/api/auth/accountVerification/" + txt_token));
    }

    public String generateVerificationToken(User user){
        String txt_token = UUID.randomUUID().toString();
        VerificationToken verification_token = new VerificationToken();
        verification_token.setUser(user);
        verification_token.setTxt_token(txt_token);
        verification_token_repo.save(verification_token);
        return txt_token;

    }

}