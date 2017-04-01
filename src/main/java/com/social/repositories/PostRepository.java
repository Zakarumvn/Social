package com.social.repositories;

import com.social.entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Katarzyna on 2017-02-18.
 */
@Repository
public interface PostRepository  extends CrudRepository<Post, Long> {
}
