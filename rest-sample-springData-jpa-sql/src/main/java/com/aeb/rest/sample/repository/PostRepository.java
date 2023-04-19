package com.aeb.rest.sample.repository;

import com.aeb.rest.sample.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {


    boolean existsByTitle(String title);

    Optional<Post> findBySlug(String slug);
}
