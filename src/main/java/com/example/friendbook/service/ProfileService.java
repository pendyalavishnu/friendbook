package com.example.friendbook.service;

import com.example.friendbook.exception.SpringFriendbookException;
import com.example.friendbook.model.Post;
import com.example.friendbook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProfileService {

    @Autowired
    PostRepository post_repo;

    @Transactional(readOnly = true)
    public List<Post> getPostsByUser (String txt_username){
        List<Post> posts = post_repo.findAllByTxt_username(txt_username);
        if(posts.size() == 0 ){
            throw new SpringFriendbookException("no posts");
        }
        System.out.println(posts.get(0).getNum_post_id());
        return posts;
    }

}
