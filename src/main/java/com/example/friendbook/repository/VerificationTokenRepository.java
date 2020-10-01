package com.example.friendbook.repository;

import com.example.friendbook.model.User;
import com.example.friendbook.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    @Query("SELECT v FROM VerificationToken  v WHERE txt_token = :txt_token")
    Optional<VerificationToken> findByTxt_token(@Param("txt_token") String txt_token);
}
