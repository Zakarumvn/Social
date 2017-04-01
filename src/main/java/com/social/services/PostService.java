package com.social.services;

import com.social.entities.Post;

import java.util.List;

/**
 * Created by Katarzyna on 2017-02-18.
 */

public interface PostService {
    public Post savePost(Post post);

    public List<Post> getAllPosts();
}

