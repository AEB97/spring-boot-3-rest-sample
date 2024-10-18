package com.aeb.rest.sample.repository;

import com.aeb.rest.sample.domain.Post;
import com.aeb.rest.sample.domain.PostStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.scheduling.annotation.Async;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {


    boolean existsByTitle(String title);

    Optional<Post> findBySlug(String slug);

    @Async
    CompletableFuture<Stream<Post>> findByPostStatus(PostStatus postStatus);


}
