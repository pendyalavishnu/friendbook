package com.example.friendbook.repository;

import com.example.friendbook.model.Post;
import com.example.friendbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p, User u WHERE p.user.num_user_id = u.num_user_id AND u.txt_username = :txt_username")
    public List<Post> findAllByTxt_username(@Param("txt_username") String txt_username);
}
