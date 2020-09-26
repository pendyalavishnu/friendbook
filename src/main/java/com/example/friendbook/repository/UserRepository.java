package com.example.friendbook.repository;

import com.example.friendbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT txt_password FROM User WHERE txt_username = :username")
    String findPasswordByUsername(@Param("username") String username);
    @Query("SELECT num_user_id FROM User WHERE txt_username = :username")
    List<Integer> findByTxt_username(@Param("username") String username);
}
