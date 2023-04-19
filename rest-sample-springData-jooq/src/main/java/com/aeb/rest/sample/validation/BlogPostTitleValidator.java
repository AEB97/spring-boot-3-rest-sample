package com.aeb.rest.sample.validation;

import com.aeb.rest.sample.dto.PostDto;
import com.aeb.rest.sample.service.PostService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;


public record BlogPostTitleValidator(
        PostService postService) implements ConstraintValidator<BlogPostTitleAlreadyExists, PostDto> {

    @Override
    public void initialize(BlogPostTitleAlreadyExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PostDto post, ConstraintValidatorContext constraintValidatorContext) {
        if (!StringUtils.isEmpty(post.getTitle()) && postService.postExistsWithTitle(post.getTitle())) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("{TitleAlreadyExists}")
                    .addPropertyNode("title")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
