package com.aeb.rest.sample.domain;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("COMMENTS")
public class Comment {
    private Integer id;
    private String title;
    private String authorName;
    private String body;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
