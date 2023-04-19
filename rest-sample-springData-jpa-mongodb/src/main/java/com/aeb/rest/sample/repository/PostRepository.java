package com.aeb.rest.sample.repository;

import com.aeb.rest.sample.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    boolean existsByTitle(String title);
}
