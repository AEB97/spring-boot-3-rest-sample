package com.aeb.rest.sample.repository;

import com.aeb.rest.sample.domain.Post;


import java.util.Set;

public interface PostRepository {
    void addPost(Post post);

    Set<Post> findAllPosts();
}
