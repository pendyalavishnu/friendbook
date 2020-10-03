package com.example.friendbook.repository;

import com.example.friendbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.txt_username = :txt_username")
    public Optional<User> findByUsername(@Param("txt_username") String txt_username);
}
