package com.aeb.rest.sample.service;

import com.aeb.rest.sample.dto.PostDto;
import com.aeb.rest.sample.repository.PostJdbcDataRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostJdbcDataRepository postRepository;

    public void addPost(PostDto postDto) {
        postDto.setCreatedOn(LocalDateTime.from(LocalDate.now()));
        postDto.setUpdatedOn(LocalDateTime.from(LocalDate.now()));
        postRepository.save(PostDto.toPost(postDto));
    }

    public Set<PostDto> findAllPosts() {
        return StreamSupport.stream(postRepository.findAll().spliterator(), false)
                .map(PostDto::toPostDto).collect(Collectors.toSet());
    }

    public boolean postExistsWithTitle(String title) {
        return postRepository.findByTitle(title).isPresent();
    }
}
