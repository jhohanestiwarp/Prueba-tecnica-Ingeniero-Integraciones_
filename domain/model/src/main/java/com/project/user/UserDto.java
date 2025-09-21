package com.project.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
public class UserDto {
    private Long id;
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}