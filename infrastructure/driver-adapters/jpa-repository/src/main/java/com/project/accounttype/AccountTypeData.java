package com.project.accounttype;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Table(name = "account_types")
public class AccountTypeData {

    @Id
    private Long id;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @Column("is_active")
    private Boolean isActive;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}
