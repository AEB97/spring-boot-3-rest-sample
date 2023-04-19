package com.aeb.rest.sample.controller;

import com.aeb.rest.sample.dto.PostDto;
import com.aeb.rest.sample.mapper.PostMapper;
import com.aeb.rest.sample.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> listPosts() {

        return postService.findAllPosts().stream().map(PostMapper::mapToPostDto).toList();
    }

   /* @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto createPost(@RequestBody @Valid PostDto postDto) {
        return postService.save(postDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public PostDto updatePost(@RequestBody @Valid PostDto postDto) {
        return postService.update(postDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postService.delete(id);
    }

    @GetMapping("/{slug}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto findPostBySlug(@PathVariable String slug) {
        return postService.findBySlug(slug);
    }*/
}
