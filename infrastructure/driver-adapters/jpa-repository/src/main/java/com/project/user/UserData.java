package com.project.user;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Table(name = "users")
public class UserData {
    @Id
    private Long id;

    @Column("username")
    private String username;

    @Column("fullname")
    private String fullname;

    @Column("email")
    private String email;

    @Column("password")
    private String password;

    @Column("role")
    private String role;

    @Column("state")
    private String state;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;}