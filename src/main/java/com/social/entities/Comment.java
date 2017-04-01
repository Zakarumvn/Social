package com.social.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Katarzyna on 2017-02-18.
 */
@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idComment;
    private String commentContent;
    private Date publicationDate;
    @ManyToOne
    @JoinColumn(name="parentId")
    private Post parent;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private User user;


    public long getIdComment() {
        return idComment;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Post getParent() {
        return parent;
    }

    public void setParent(Post parent) {
        this.parent = parent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
