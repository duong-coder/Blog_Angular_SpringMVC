package com.dependency.inject.stack.service.dto;

import com.dependency.inject.stack.domain.Authority;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

/**
 * The type User dto.
 */
@Data
public class UserDTO {

    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String phone;

    private Integer gender;

    private String imageUrl;

    private String email;

    private Instant birthday;

    private String address;

    private String password;

    private Integer activated;

    private Instant createdDate;

    private Instant lastUpdatedDate;

    private List<Authority> authorities;

    private List<String> authoritiesAsString;

    private List<Long> authoritiesAsLong;

}