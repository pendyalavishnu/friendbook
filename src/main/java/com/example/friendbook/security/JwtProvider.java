package com.example.friendbook.security;

import com.example.friendbook.exception.SpringFriendbookException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

import static io.jsonwebtoken.Jwts.parser;

@Service
public class JwtProvider {

    private KeyStore key_store;

    @PostConstruct
    public void init(){
        try{
            key_store = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks");
            key_store.load(resourceAsStream, "secret".toCharArray());
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | java.io.IOException e){
            throw new SpringFriendbookException("Exception occured while loading keystore");
        }
    }

    public String generateToken(Authentication authentication){
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder().setSubject(principal.getUsername()).signWith(getPrivateKey()).compact();
    }

    private PrivateKey getPrivateKey(){
        try{
            return (PrivateKey) key_store.getKey("springblog", "secret".toCharArray());
        }catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e){
            throw new SpringFriendbookException("Exception occured while retreiving key");
        }
    }

    public boolean validateToken(String jwt){
        parser().setSigningKey(getPublicKey()).parseClaimsJws(jwt);
        return true;
    }

    private PublicKey getPublicKey(){
        try{
            return key_store.getCertificate("springblog").getPublicKey();
        }catch(KeyStoreException e){
            throw  new SpringFriendbookException("Exception occured while retreiving public key");
        }
    }

    public String getUsernameFromJwt(String txt_token){
        Claims claims = parser().setSigningKey(getPublicKey()).parseClaimsJws(txt_token).getBody();
        return claims.getSubject();
    }
}
