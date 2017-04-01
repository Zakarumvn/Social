package com.social.entities;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Katarzyna on 2017-02-18.
 */
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long idPost;

    private String postContent;

    private Timestamp publicationDate;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;

    @OneToMany(mappedBy = "parent")
    private List<Comment> comments;

    public Post(){}

    public Post(String postContent, Timestamp publicationDate, User user, List<Like> likes, List<Comment> comments) {
        this.postContent = postContent;
        this.publicationDate = publicationDate;
        this.user = user;
        this.likes = likes;
        this.comments = comments;
    }


    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Timestamp getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Timestamp publicationDate) {
        this.publicationDate = publicationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
