package com.aeb.rest.sample.service;

import com.aeb.rest.sample.exception.SpringBlogException;
import com.aeb.rest.sample.repository.CommentRepository;
import com.aeb.rest.sample.repository.PostRepository;
import com.aeb.rest.sample.domain.Comment;
import com.aeb.rest.sample.domain.Post;
import com.aeb.rest.sample.dto.CommentDto;
import com.aeb.rest.sample.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public List<CommentDto> findByPost(String slug) {
        Post post = getPostBySlug(slug);
        return post.getComments()
                .stream()
                .map(commentMapper::mapToCommentDto)
                .toList();
    }

    public void create(CommentDto commentDto, String slug) {
        Comment comment = commentMapper.mapToComment(commentDto);
        comment.setCreatedOn(LocalDateTime.now());
        comment.setUpdatedOn(LocalDateTime.now());
        Post postBySlug = getPostBySlug(slug);
        comment.setPost(postBySlug);
        commentRepository.save(comment);
        postBySlug.getComments().add(comment);
        postRepository.save(postBySlug);
    }

    private Post getPostBySlug(String slug) {
        return postRepository.findBySlug(slug)
                .orElseThrow(() -> new SpringBlogException("Cannot find post by slug - " + slug));
    }
}