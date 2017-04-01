package com.social.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Katarzyna on 2017-02-18.
 */
@Entity
@Table(name="likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idLike;
    private long idLikeable;

    @ManyToOne
    @JoinColumn(name="ownerId")
    private Post post;

    @ManyToMany
    private List<User> users;

    public long getIdLike() {
        return idLike;
    }

    public void setIdLike(long idLike) {
        this.idLike = idLike;
    }

    public long getIdLikeable() {
        return idLikeable;
    }

    public void setIdLikeable(long idLikeable) {
        this.idLikeable = idLikeable;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

