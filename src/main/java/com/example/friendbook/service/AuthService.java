package com.example.friendbook.service;

import com.example.friendbook.dto.LoginRequest;
import com.example.friendbook.dto.RegisterRequest;
import com.example.friendbook.exception.SpringFriendbookException;
import com.example.friendbook.model.NotificationEmail;
import com.example.friendbook.model.User;
import com.example.friendbook.model.VerificationToken;
import com.example.friendbook.repository.UserRepository;
import com.example.friendbook.repository.VerificationTokenRepository;
import com.sun.jmx.remote.security.MBeanServerFileAccessController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AuthService {

    @Autowired
    BCryptPasswordEncoder password_encoder;
    @Autowired
    UserRepository user_repo;
    @Autowired
    VerificationTokenRepository verification_token_repo;
    @Autowired
    MailService mail_service;


    public void verfifyAccount(String txt_token) {
        Optional<VerificationToken> verification_token = verification_token_repo.findByTxt_token(txt_token);
        verification_token.orElseThrow(() -> new SpringFriendbookException("Invalid token"));
//        if(verification_token == null){
//            throw new SpringFriendbookException("Invalid token");
//        }
        fetchAndEnableUser(verification_token.get());
    }

    @Transactional
    public void fetchAndEnableUser(VerificationToken verification_token){
        Long num_user_id = verification_token.getUser().getNum_user_id();
        User user = user_repo.findById(num_user_id).orElseThrow(() -> new SpringFriendbookException("User does not exist"));
        user.setFlg_is_enabled(true);
        user_repo.save(user);
    }

    public void signup(RegisterRequest register_request){
        User user = new User();
        user.setTxt_username(register_request.getTxt_username());
        user.setTxt_email(register_request.getTxt_email());
        user.setTxt_password(password_encoder.encode(register_request.getTxt_password()));
        user.setCreated(Instant.now());
        user.setFlg_is_enabled(false);
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

    public void login(LoginRequest login_request) {

    }
}
