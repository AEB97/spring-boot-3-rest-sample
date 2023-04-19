package com.aeb.rest.sample.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer id;
    private String title;
    private String authorName;
    private String body;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
