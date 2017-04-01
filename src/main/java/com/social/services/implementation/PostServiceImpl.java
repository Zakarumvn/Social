package com.social.services.implementation;

import com.social.entities.Post;
import com.social.repositories.PostRepository;
import com.social.services.PostService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Katarzyna on 2017-02-18.
 */
@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;
    @Autowired
    public void setPostRepository(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @Override
    public Post savePost(Post post){
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts(){
        return (List<Post>)postRepository.findAll();
    }
}
