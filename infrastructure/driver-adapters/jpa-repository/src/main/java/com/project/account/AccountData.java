package com.project.account;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Table(name = "enrolled_accounts")
public class AccountData {

    @Id
    private Long id;

    @Column("account_number")
    private String accountNumber;

    @Column("cellphone")
    private String cellphone;

    @Column("alias")
    private String alias;

    @Column("type_document")
    private String typeDocument;

    @Column("document")
    private String document;

    @Column("is_internal_bank")
    private Boolean isInternalBank;

    @Column("status")
    private String status;

    @Column("user_id")
    private Long userId;

    @Column("bank_id")
    private Long bankId;

    @Column("account_type_id")
    private Long accountTypeId;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}