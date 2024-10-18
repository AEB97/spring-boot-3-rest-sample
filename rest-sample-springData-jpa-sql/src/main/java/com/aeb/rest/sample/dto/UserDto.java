package com.aeb.rest.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.aeb.rest.sample.domain.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String name;
}