package com.social.controllers;

import com.social.entities.Post;
import com.social.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Katarzyna on 2017-02-18.
 */
@Controller
public class PostController {
    private PostService postService;

    @Autowired
    private void setPostService(PostService postService){
        this.postService = postService;
    }

    @RequestMapping(value = "/wall", method = RequestMethod.GET)
    public String newPost(Model model){
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("post", new Post());
        model.addAttribute("posts", posts);
        return "wall";
    }

    @RequestMapping(value = "/wall", method = RequestMethod.POST)
    public String savePost(Post post){
        post.setPublicationDate(new Timestamp((new Date()).getTime()));
        postService.savePost(post);
        return "redirect:/wall";
    }
}
