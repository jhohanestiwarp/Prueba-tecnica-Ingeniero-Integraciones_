package com.project.account;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Table(name = "accounts")
public class AccountData {

    @Id
    private Long id;

    @Column("bank")
    private String bank;

    @Column("type")
    private String type;

    @Column("number")
    private String number;

    @Column("alias")
    private String alias;

    @Column("cellphone")
    private String cellphone;

    @Column("state")
    private String state;

    @Column("user_id")
    private Long userId;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}